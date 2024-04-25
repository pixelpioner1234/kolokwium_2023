import java.util.ArrayList;
import java.util.List;

public class Polygon {

    private List<Point> points;

    public Polygon (List<Point> points){
        this.points = points;
    }
    public Polygon(){

    }


    public List<Point> getPoints() {
        return points;
    }
    public void setPoints(List<Point> points) {
        this.points = points;
    }


    public boolean inside(Point point){
        List<Line> lines = generateLines(this.points);
        int counter = 0;

        for(int i = 0; i < lines.size(); i++){
            Line currentLine = lines.get(i);

            Point pa = currentLine.getPointA();
            Point pb = currentLine.getPointB();

            if(pa.getY() > pb.getY()){
                Point temp = pa;
                pa = pb;
                pb = temp;
            }

            if (pa.getY() < point.getY() &&  point.getY() < pb.getY()){
                double d = pb.getX() - pa.getX();
                double x ;

                if (d == 0){
                    x = pa.getX();
                }else{
                    double a = (pb.getY() - pa.getY()) / d;
                    double b = pa.getY() - a * pa.getX();
                    x = (point.getY() - b) / a ;
                }

                if(x < point.getX()){
                    counter++; }
            }
        }
        if (counter % 2 != 0){
            return true;
        } else {
            return false;
        }
    }


    public  List<Line> generateLines(List<Point> points){
        List<Line> tempLines = new ArrayList<>();
        for(int i = 0; i < points.size(); i++){
            Point a = points.get(i);
            Point b;
            if (i < points.size()-1){
                b = points.get(i+1);
            }else{
                b = points.get(0);
            }

            Line line = new Line(a,b);
            tempLines.add(line);
        }
        return tempLines;
    }


    public static double calculateRange(Point p1, Point p2){
        double range = Math.sqrt(Math.pow( p2.getX()- p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        return range;
    }










}
