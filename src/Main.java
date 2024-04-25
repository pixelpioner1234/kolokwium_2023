import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args){

        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(5, 2);

        List<Point> pointList = new ArrayList<>();
        pointList.add(p1);
        pointList.add(p2);
        pointList.add(p3);
        pointList.add(p4);

        Polygon polygon = new Polygon(pointList);

        //System.out.println(polygon.lines.get(1).pointA.getX());

        //System.out.println(polygon.inside(new Point(3,3)));
        //System.out.println(polygon.inside(new Point(1,1)));

        Land land = new Land(pointList);

        Town town1 = new Town(1, new Point(3,3), "Lida");
        land.addCity(town1);

        Town town2 = new Town(1, new Point(1,1), "Lublin");
        land.addCity(town2);


        System.out.println(town1.getIsPort());

        /*Set<Point> points = new HashSet<>();
        Point point1 = new Point(2,2);
        //Point point2 = new Point(2,2);
        Point point2 = point1;
        points.add(point1);
        points.add(point2);
        System.out.println(points.size());*/


        MapParser mapParser = new MapParser();
        mapParser.parse("C:\\kolokwium1_2022\\map.svg");
        System.out.println(mapParser.labels.get(0).getName());
        System.out.println(mapParser.labels.get(1).getName());
        for(Label label : mapParser.labels){
            System.out.println(label.getName());
        }

    }

}
