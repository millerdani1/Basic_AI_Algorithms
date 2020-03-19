import java.util.Comparator;

public class PointDistance implements Comparator<PointDistance>, Comparable<PointDistance> {
    private double distance;
    private int wineClass;

    public PointDistance(double distance, int wineClass) {
        this.distance = distance;
        this.wineClass = wineClass;
    }

    public double getDistance() {
        return distance;
    }

    public int getWineClass() {
        return wineClass;
    }

    @Override
    public int compareTo(PointDistance o) {
        if (o.distance > this.distance) return -1;
        else if (o.distance < this.distance) return 1;
        else return 0;
    }

    @Override
    public int compare(PointDistance o1, PointDistance o2) {
        return (int) (o1.distance - o2.distance);
    }
}
