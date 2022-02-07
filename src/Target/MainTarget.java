package Target;

import java.sql.SQLOutput;

public class MainTarget {
    public static void main(String[] args) {
        int counterIn=0;
        int counterOut=0;
        int numberOfThrows=50000;
        for (int i=0;i<numberOfThrows;i++){
            Point target=new Point();
            System.out.println(target);
            if (target.distanceToOrigin()<=1)
                counterIn++;
            else counterOut++;
            System.out.println(counterIn);
            System.out.println(counterOut);
            System.out.println((double)counterIn/(i+1)*4);
        }
    }
}
