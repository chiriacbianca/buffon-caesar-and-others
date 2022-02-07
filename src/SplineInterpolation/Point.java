package SplineInterpolation;

public class Point {
    private float coordinateX;
    private float coordinateY;

    public Point(float coordinateX, float coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Point() {
    }

    public float getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(float coordinateX) {
        this.coordinateX = coordinateX;
    }

    public float getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(float coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString() {
        return "Point{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }

    public static void swapNumbers(Point[] arrayOfPoints, int i, int j){
        Point temporary=arrayOfPoints[i];
        arrayOfPoints[i]=arrayOfPoints[j];
        arrayOfPoints[j]=temporary;
    }

    public static void bubbleSort(Point[] arrayOfPoints)
    {
        int n = arrayOfPoints.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayOfPoints[j].getCoordinateX() > arrayOfPoints[j + 1].getCoordinateX()) {
                    // swap arr[j+1] and arr[j]
                    Point temp = new Point();
                    temp = arrayOfPoints[j];
                    arrayOfPoints[j] = arrayOfPoints[j + 1];
                    arrayOfPoints[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSortedArrays(Point[] arrayOfPoints, Point[] newPoints, Point[] resultedPoints){
        int i = 0, j = 0, k = 0;
        while (i<arrayOfPoints.length && j<newPoints.length){
            if (arrayOfPoints[i].getCoordinateX() < newPoints[j].getCoordinateX())
                resultedPoints[k++] = arrayOfPoints[i++];
            else
                resultedPoints[k++] = newPoints[j++];
        }
        while (i < arrayOfPoints.length)
            resultedPoints[k++] = arrayOfPoints[i++];


        while (j < newPoints.length)
            resultedPoints[k++] = newPoints[j++];
    }
}
