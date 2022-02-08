package Buffon;
import Target.Point;
import java.util.Random;

public class BuffonNeedle {
    public static void main(String[] args) throws java.lang.ArithmeticException {
        Random rand=new Random(System.currentTimeMillis());
        int numberOfThrows = 100000;
        int intersection=0;
        int noIntersection=0;
        double approximationOfPi;
        int anotherMethodYes=0;
        int anotherMethodNo=0;

        for (int i = 0; i < numberOfThrows; i++) {
            Point point=new Point();
            double angle = Math.toRadians(rand.nextInt(90)+Math.random());
            //Eu am presupus L=1, si am lucrat pentru aceasta valoare
            double otherY=point.getCoordinateY()+Math.sin(angle);

            if (otherY-point.getCoordinateY()>=1-point.getCoordinateY())
                intersection++;
            else
                noIntersection++;

            if ((int)point.getCoordinateY()!=(int)otherY){
                anotherMethodYes++;
            }
            else
                anotherMethodNo++;

            System.out.println("Intersections: "+intersection);
            System.out.println("No intersection: "+noIntersection);
            approximationOfPi=2*(double)(i+1)/intersection;
            System.out.println(approximationOfPi);
            System.out.println(2*(double)(i+1)/anotherMethodYes);
        }
    }
}
