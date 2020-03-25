import java.util.ArrayList;

public class KMeansAlgorithm {
    
    public static void runAlgorithm(ArrayList<WineObject> data, Double[] ranges, int kValue) {
        ArrayList<ClusterObject> centroids = new ArrayList<ClusterObject>();
        
        
        //place centroids at random positions
        for(int i=0;i<kValue;i++){
            centroids.add(new ClusterObject());
        }
        
        //while the centroids are moving
        for (int yeet =0;yeet<150;yeet++){
            
            //for each point find the nearest centroid
            for(int i=0;i<data.size();i++){
                for(int j=0;j<centroids.size();j++){
                    calculateEuclidianDistance(data.get(i).getAttributes(), centroids.get(j).getCentroidPosition(), ranges);
                }
            }

            //for each cluster, move the clusters centroid to mean position
            for(int c=0;c<centroids.size();c++){
                
            }
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

}
