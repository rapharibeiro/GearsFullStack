import data.Gear;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resource.GearResource;
import service.GearService;

public class Main {

    public static void main(String[] args) throws Exception {

        GearService gearServiceHardCoded = new GearService();
        gearServiceHardCoded.create(new Gear("SD-1", "Overdrive", "Boss"));
        gearServiceHardCoded.create(new Gear("DS-1", "Distortion", "Boss"));
        gearServiceHardCoded.create(new Gear("Flint", "Reverb", "Strymon"));
        gearServiceHardCoded.create(new Gear("Drop", "Octave", "Digitech"));
        gearServiceHardCoded.create(new Gear("P90", "Phaser", "TC Eletronic"));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", GearResource.class.getCanonicalName());

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
