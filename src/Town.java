import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Town extends  Polygon{
    public Point center;
    private String cityName;
    private boolean isPort;
    public Set<Resource> resourcesSet;

    public boolean getIsPort() {
        return isPort;
    }
    public void setPort(boolean port){isPort = port;}
    public Point getCenter() {
        return center;
    }
    public String getCityName() {
        return cityName;
    }

    public Town(double wallLength, Point center, String cityName) {
        this.resourcesSet = new HashSet<>();
        this.center = center;
        this.cityName = cityName;
        List<Point> cityPoints = this.cityWallsPoints(wallLength, center);
        this.setPoints(cityPoints);
    }


    public List<Point> cityWallsPoints(double wallLength, Point center){
        List<Point>  cityWallsPoints = new ArrayList<>();

        Point p1 = new Point(center.getX()-wallLength/2, center.getY()+wallLength/2);
        Point p2 = new Point(center.getX()+wallLength/2, center.getY()+wallLength/2);
        Point p3 = new Point(center.getX()+wallLength/2, center.getY()-wallLength/2);
        Point p4 = new Point(center.getX()-wallLength/2, center.getY()-wallLength/2);

        cityWallsPoints.add(p1);
        cityWallsPoints.add(p2);
        cityWallsPoints.add(p3);
        cityWallsPoints.add(p4);

        return cityWallsPoints;
    }


    public Set<Resource> addResourcesInRange(List<Resource> resources, double range){
        for (Resource resource : resources) {
            double rangeBetweenCityAndResource = calculateRange(resource.point, center);

            if(rangeBetweenCityAndResource <= range){
                if(resource.type == Type.Fish){
                    if(isPort){
                        resourcesSet.add(resource);

                    }
                }else{
                    resourcesSet.add(resource);
                }
            }
        }
        return  resourcesSet;
    }









}
