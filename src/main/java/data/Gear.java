package data;

import java.util.Objects;

public class Gear {

    private int id;
    private String name;
    private String effect;
    private String brand;

    public Gear(String name, String effect, String brand) {
        this.name = name;
        this.effect = effect;
        this.brand = brand;
    }

    public Gear() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gear gear = (Gear) o;
        return Objects.equals(id, gear.id) && Objects.equals(name, gear.name) && Objects.equals(effect, gear.effect) && Objects.equals(brand, gear.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, effect, brand);
    }
}
