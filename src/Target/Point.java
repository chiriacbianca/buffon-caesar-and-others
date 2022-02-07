package Target;

import java.util.Random;

public class Point {
    private double coordinateX;
    private double coordinateY;

    public Point(){
        this.coordinateX=Math.random();
        this.coordinateY=Math.random();
    }

    Point(double x, double y){
        this.coordinateX=x;
        this.coordinateY=y;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public double distanceBetweenPoints(Point anotherPoint){
        return Math.sqrt(Math.pow(Math.abs(this.coordinateX-anotherPoint.coordinateX),2)+Math.pow(Math.abs(this.coordinateY-anotherPoint.coordinateY),2));
    }
    public double distanceToOrigin(){
        return Math.sqrt(Math.pow(this.coordinateX,2)+Math.pow(this.coordinateY,2));
    }

    @Override
    public String toString() {
        return "Point{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }
}
