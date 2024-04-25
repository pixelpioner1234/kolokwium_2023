import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class LandTest {
    Land land;

    @BeforeEach
    public void setUp() {

        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(5, 2);

        List<Point> pointList = new ArrayList<>();
        pointList.add(p1);
        pointList.add(p2);
        pointList.add(p3);
        pointList.add(p4);

        land = new Land(pointList);
    }

    @Test
    public void addCorrectCityTest() {
        Town town1 = new Town(1, new Point(3,3), "Lida");
        land.addCity(town1);
        assertTrue(land.getCities().contains(town1));
    }

    @Test
    public void addIncorrectCityTest() {
        Town town1 = new Town(1, new Point(1,1), "Minsk");
        land.addCity(town1);
        assertFalse(land.getCities().contains(town1));
    }

    @Test
    public void checkPortCityTest() {
        Town town1 = new Town(1, new Point(3,3), "Lida");
        assertFalse(land.checkPortCity(town1));
    }
}