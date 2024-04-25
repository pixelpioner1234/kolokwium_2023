import java.util.ArrayList;
import java.util.List;

public class Land extends Polygon{

    private List<Town> cities;

    public Land(List<Point> points ) {
        super(points);
        cities = new ArrayList<>();
    }

    public List<Town> getCities() {
        return cities;
    }

    public void addCity(Town city){

        try {
            boolean inLand = inside(city.getCenter());
            if(inLand){
                cities.add(city);
                checkPortCity(city);
                System.out.println("City is added to the list.");      //"City " + city.getCityName() + " is added to the list."
            }else{
                throw new RuntimeException("City " + city.getCityName() + " isn't added to the list.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());                                                                    //"City " + city.getCityName() + " isn't added to the list.");
        }


        /*boolean inLand = inside(city.getCenter());
        if(inLand){
            cities.add(city);
            checkPortCity(city);
            System.out.println("City " + city.getCityName() + " is added to the list.");
        }else{
            //System.out.println("City " + city.getCityName() + " isn't added to the list.");
            throw new RuntimeException("City " + city.getCityName() + " isn't added to the list.");
        }*/
    }

    public boolean checkPortCity(Town city){
        for(int i=0; i < city.getPoints().size(); i++){
            if(!inside(city.getPoints().get(i))){
                city.setPort(true);
                return true;
            }
        }
        city.setPort(false);
        return  false;
    }


}
