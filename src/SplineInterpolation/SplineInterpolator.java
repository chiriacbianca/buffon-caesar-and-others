package SplineInterpolation;

import java.util.Arrays;
import java.util.Scanner;


public class SplineInterpolator {
    Point[] arrayOfPoints;
    private int size;
    private int numberOfPartitions;
    Point[] newArrayOfPoints;
    public Point[] interpolatedPoints;

    public SplineInterpolator(Scanner scanner, int size, int numberOfPartitions) {
        this.size = size;
        this.numberOfPartitions=numberOfPartitions;
        arrayOfPoints=new Point[size];
        for (int i=0;i<size;i++){
            Point point=new Point();
            point.setCoordinateX(scanner.nextFloat());
            point.setCoordinateY(scanner.nextFloat());
            arrayOfPoints[i]=point;

        }
        Point.bubbleSort(arrayOfPoints);
        newArrayOfPoints=newArrayOfPoints();
        interpolatedPoints=new Point[size+numberOfPartitions-2];
        interpolate();

    }

    public Point[] newArrayOfPoints(){
        float aMargin=arrayOfPoints[0].getCoordinateX();
        float bMargin=arrayOfPoints[size-1].getCoordinateX();
        float distance=(bMargin-aMargin)/numberOfPartitions;
        Point[] newPoints= new Point[numberOfPartitions];
        for (int i=0;i<numberOfPartitions;i++){
            Point point=new Point();
            point.setCoordinateX(aMargin+i*distance);
            newPoints[i]=point;
            System.out.println(newPoints[i]);
        }
        return newPoints;
    }

    public void interpolate(){
        interpolatedPoints[0]=arrayOfPoints[0];
        int i=1;
        int j=1;
        for (int k=1; k<interpolatedPoints.length;k++ ){
            if (k ==interpolatedPoints.length - 1) {
                interpolatedPoints[interpolatedPoints.length - 1] = arrayOfPoints[arrayOfPoints.length-1];
            }
            else{
                if (arrayOfPoints[i].getCoordinateX()<newArrayOfPoints[j].getCoordinateX()){
                    interpolatedPoints[k]=arrayOfPoints[i];
                    i++;
                }
                else {
                    float xDifference1 = newArrayOfPoints[j].getCoordinateX() - interpolatedPoints[k - 1].getCoordinateX();
                    float xDifference2 = arrayOfPoints[i].getCoordinateX() - interpolatedPoints[k - 1].getCoordinateX();
                    float yDifference = arrayOfPoints[i].getCoordinateY() - interpolatedPoints[k - 1].getCoordinateY();
                    float yValue = yDifference * xDifference1 / xDifference2 + interpolatedPoints[k - 1].getCoordinateY();

                    newArrayOfPoints[j].setCoordinateY(yValue);
                    interpolatedPoints[k] = newArrayOfPoints[j];
                    j++;
                }

            }
        }
       /* *//*while (i<arrayOfPoints.length-1){
            interpolatedPoints.;
            i++;
            k++;*//*
        }*/
    }

    @Override
    public String toString() {
        return "SplineInterpolator{" +
                "arrayOfPoints=" + Arrays.toString(arrayOfPoints) +
                ", size=" + size +
                ", numberOfPartitions=" + numberOfPartitions +
                ", \nnewArrayOfPoints=" + Arrays.toString(newArrayOfPoints) +
                ", \ninterpolatedPoints=" + Arrays.toString(interpolatedPoints) +
                '}';
    }

}
