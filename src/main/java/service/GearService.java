package service;

import data.Gear;

import java.util.ArrayList;
import java.util.List;

public class GearService {

    private static final List<Gear> gears = new ArrayList<>();

    public List<Gear> findAll() {
        return gears;
    }

    public Gear findById(String id) {
        return gears.stream().filter(g -> g.getId() == Integer.parseInt(id)).findFirst().orElse(null);
    }

    public List<Gear> create(Gear gear) {
        if (gear.getId() == 0)
            gear.setId(generateId());
        gears.add(gear);
        return gears;
    }

    public void update(Gear gear) {
        delete(gear);
        create(gear);
    }

    public void delete(Gear gear) {
        gears.remove(findById(String.valueOf(gear.getId())));
    }

    private int generateId() {
        return gears.size() + 1;
    }
}
