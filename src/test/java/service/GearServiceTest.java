package service;

import data.Gear;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class GearServiceTest {

    GearService service;

    @BeforeEach
    void setUp() {
        service = new GearService();
    }

    @Test
    public void addTest() {
        service.create(Mockito.mock(Gear.class));
        service.create(Mockito.mock(Gear.class));
        service.create(Mockito.mock(Gear.class));

        assertThat(service.findAll()).hasSize(3);
    }

    @Test
    public void delTest() {
        service.create(Mockito.mock(Gear.class));
        service.create(Mockito.mock(Gear.class));
        service.create(Mockito.mock(Gear.class));

        service.delete(Mockito.mock(Gear.class));

        //gears list is static
        assertThat(service.findAll()).hasSize(5);
    }
}