package resource;

import data.Gear;
import service.GearService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gears")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GearResource {

    private final GearService gearService = new GearService();

    @GET
    public List<Gear> get() {
        return gearService.findAll();
    }

    @GET
    @Path("/{id}")
    public Gear getById(@PathParam("id") String id) {
        return gearService.findById(id);
    }

    @POST
    public List<Gear> add(Gear gear) {
        return gearService.create(gear);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") String id, Gear gear) {
        Gear byId = gearService.findById(id);
        if (byId == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try {
            gear.setId(Integer.parseInt(id));
            gearService.update(gear);
            return Response.status(Response.Status.OK).entity(gear).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) {
        Gear gear = gearService.findById(id);
        if (gear == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try {
            gearService.delete(gear);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }
}
