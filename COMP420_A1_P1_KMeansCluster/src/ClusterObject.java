import java.util.Random;

public class ClusterObject {

    private double[] centroidPosition;

    public ClusterObject(RangeData range){
    //place cluster at random position
        centroidPosition = new double[range.getMaxValues().length];
        for(int i=0;i<range.getMaxValues().length;i++){
            centroidPosition[i] = range.getMinValues()[i] + new Random().nextDouble() * (range.getMaxValues()[i] - range.getMinValues()[i]);
        }
    }

    public double[] getCentroidPosition() {
        return centroidPosition;
    }

    public void setCentroidPosition(double[] centroidPosition) {
        this.centroidPosition = centroidPosition;
    }
}
