package SplineInterpolation;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class MainInterpolation {
    public static void main(String[] args) throws FileNotFoundException {
        Random rand=new Random(System.currentTimeMillis());
        int numberOfGivenPoints=20;
        try {
            PrintWriter fileout = new PrintWriter(new FileWriter("C:\\Users\\bianca info\\IdeaProjects\\com.CapSpecJ\\src\\SplineInterpolation\\input.txt"));
            for (int i = 0; i < numberOfGivenPoints; i++) {
                Float coordinateX=rand.nextInt(10)+rand.nextFloat();
                Float coordinateY=rand.nextInt(10)+rand.nextFloat();
                fileout.println(coordinateX+" "+coordinateY);
            }
            fileout.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        Scanner scanner=new Scanner(new File("C:\\Users\\bianca info\\IdeaProjects\\com.CapSpecJ\\src\\SplineInterpolation\\input.txt"));
        int numberPartitions=45;
        SplineInterpolator interpolator= new SplineInterpolator(scanner, numberOfGivenPoints, numberPartitions);
        System.out.println(interpolator);
        

    }
}
