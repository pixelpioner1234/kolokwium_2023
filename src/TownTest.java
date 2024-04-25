import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TownTest {
    public Town portTown;
    public Town notPortTown;
    public List<Resource> resources;

    @BeforeEach
    public void SetUp(){
        resources = new ArrayList<>();
        Resource res1 = new Resource(new Point(1,6), Type.Fish);
        Resource res2 = new Resource(new Point(-3,-2), Type.Wood);
        Resource res3 = new Resource(new Point(1,-4), Type.Coal);
        Resource res4 = new Resource(new Point(-1,2), Type.Fish);
        resources.add(res1);
        resources.add(res2);
        resources.add(res3);
        resources.add(res4);


        portTown = new Town(1, new Point(-3,2), "Madrid");
        portTown.setPort(true);

        notPortTown = new Town(1, new Point(2,-2), "Soul");
        notPortTown.setPort(false);

    }

    @Test
    void  PoprawneDodanieWegla() {
        Set<Resource> result = notPortTown.addResourcesInRange(resources, 3);
        assertTrue(result.contains(resources.get(2)));
    }

    @Test
    void  NieudanąDodanieWegla() {
        Set<Resource> result = portTown.addResourcesInRange(resources, 1);
        assertFalse(result.contains(resources.get(2)));
    }

    @Test
    void PoprawneDodaniaDrewna() {
        Set<Resource> result = notPortTown.addResourcesInRange(resources, 5);
        assertTrue(result.contains(resources.get(1)));

    }

    @Test
    void NieudanąDodaniaDrewna() {
        Set<Resource> result = portTown.addResourcesInRange(resources, 2);
        assertFalse(result.contains(resources.get(1)));

    }

    @Test
    void PoprawneDodanieRyb() {
        Set<Resource> result = portTown.addResourcesInRange(resources, 1);
        assertTrue(result.contains(resources.get(3)));
    }


    @Test
    void NieudanąDodaniaRyb() {
        Set<Resource> result = notPortTown.addResourcesInRange(resources, 2);
        assertFalse(result.contains(resources.get(0)));
    }


}