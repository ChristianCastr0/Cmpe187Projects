import java.lang.Math;

public class ProgressBar {
    private double progress;
    private int[] unitVector = {0, 1};
    private int radius = 50;

    public ProgressBar() {
        this.progress = 0;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public boolean isBlue(double x, double y) {
        double progressAngle = this.progress * 360;

        double x_p = convertCoord(x);
        double y_p = convertCoord(y);

        String angleBetween = Double.toString(radiansToDegrees(angleBetween(x_p, y_p))); 
        String distance = Double.toString(euclideanDistance(x_p, y_p));

        boolean found = false;

        if(angleBetween(x_p, y_p) < progressAngle && euclideanDistance(x_p, y_p) < radius) {
            found = false;
        }
        else {
            found = true;
        }
        System.out.println("Angle between point and origin: " + angleBetween);
        System.out.println("Distance between origin and point: " +  distance);

        return found;
    }

    private double convertCoord(double val) {
        // Change point to a coordinate system with (0, 0) at the center of the square
        return val - 50;
    }

    private double euclideanDistance(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private double dotProduct(double x, double y) {
        return unitVector[0] * x + unitVector[1] * y;
    }

    private double angleBetween(double x, double y) {
        double angle = Math.acos(dotProduct(x, y) / euclideanDistance(x, y));
        return angle;
    }

    private double radiansToDegrees(double radians) {
        return radians * (180 / Math.PI);
    }
}