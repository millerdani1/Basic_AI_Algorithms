import java.util.ArrayList;
import java.util.Arrays;

public class KMeansAlgorithm {
    
    public static void runAlgorithm(ArrayList<WineObject> data, int kValue) {
        RangeData range = new RangeData(data);
        ArrayList<ClusterObject> centroids = new ArrayList<ClusterObject>();
        
        
        //create k centroids at random positions
        for(int i=0;i<kValue;i++){
            centroids.add(new ClusterObject(range));
        }


        //until convergence
        boolean hasReachedConvergence = false;
        while (!hasReachedConvergence){
            clearDataPoints(centroids);

            //for each point find the nearest centroid
            for(int i=0;i<data.size();i++){
                int nearestCentroid = 0;
                double nearestCentroidDistance = Double.MAX_VALUE;
                for(int j=0;j<centroids.size();j++){
                    double distance = calculateEuclidianDistance(data.get(i).getAttributes(), centroids.get(j).getCentroidPosition(), range.getRange());
                    if(distance<nearestCentroidDistance){
                        nearestCentroidDistance = distance;
                        nearestCentroid=j;
                    }
                }
                centroids.get(nearestCentroid).addDataPoint(data.get(i));
            }

            //for each cluster, move the centroid to mean position
            hasReachedConvergence = true;
            for(int c=0;c<centroids.size();c++){
                //ensure cluster has at least one data point
                if(!centroids.get(c).getClosestDataPoints().isEmpty()) {
                    //find mean position in cluster
                    double[] meanPos = calculateMeanPosition(centroids.get(c));

                    if (!Arrays.equals(meanPos, centroids.get(c).getCentroidPosition()))
                        hasReachedConvergence = false;

                    //move centroid to mean position
                    centroids.get(c).setCentroidPosition(meanPos);
                }
            }
        }

        //print out cluster data
        System.out.println("K Value: "+kValue);
        System.out.println("----------------");
        for(int i =0;i<centroids.size();i++){
            String actualClassString ="Cluster " + (i+1) + ":\n" + "Actual classes: ";
            for(int j=0;j<centroids.get(i).getClosestDataPoints().size();j++){
                actualClassString = actualClassString + centroids.get(i).getClosestDataPoints().get(j).getWineClass();
                if(j!=centroids.get(i).getClosestDataPoints().size()-1)
                    actualClassString = actualClassString+", ";
            }
            System.out.println(actualClassString);
        }
        
        
    }

    private static void clearDataPoints(ArrayList<ClusterObject> centroids) {
        for(int i=0;i<centroids.size();i++){
            centroids.get(i).clearDataPoints();
        }
    }

    //calculates Euclidian distance between n dimensional vectors
    private static double calculateEuclidianDistance(double[] point1, double[] point2, Double[] ranges) {
        double total = 0.0;
        for (int i = 0; i < point1.length; i++) {
            total = total + Math.pow((point1[i] - point2[i]), 2.0) / Math.pow(ranges[i], 2.0);
        }
        return Math.sqrt(total);
    }

    private static double[] calculateMeanPosition(ClusterObject cluster){

        double[] newPos = new double[cluster.getClosestDataPoints().get(0).getAttributes().length];

        for(int i =0; i < cluster.getClosestDataPoints().size();i++){
            for(int j =0;j<cluster.getClosestDataPoints().get(i).getAttributes().length; j++){
                newPos[j] = newPos[j] + cluster.getClosestDataPoints().get(i).getAttributes()[j];
            }
        }
        for(int r =0;r<newPos.length;r++){
            newPos[r] = newPos[r]/cluster.getClosestDataPoints().size();
        }
        return newPos;

    }
}
