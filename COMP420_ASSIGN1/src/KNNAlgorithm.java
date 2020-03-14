import java.util.*;

public class KNNAlgorithm {

    public static void runAlgorithm(ArrayList<WineTestObject> training, ArrayList<WineTestObject> test, int kValue){

        //for all points in the test data
        for(int i = 0; i<1; i++){

            //find distance to each training point and store in sorted list
            List<PointDistance> distanceList = new ArrayList<PointDistance>();
            for(int j = 0; j<training.size();j++){
                distanceList.add(new PointDistance(calculateEuclidianDistance(test.get(i).getAttributes(), training.get(j).getAttributes()), training.get(j).getWineClass()));
            }
            Collections.sort(distanceList);

            //choose first k points
            ArrayList<Integer> classFrequency = new ArrayList<Integer>();
            for(int q = 0; q <kValue; q++){
                classFrequency.add(distanceList.get(q).getWineClass());
            }
            //assign class to





        }







    }

    private static double calculateEuclidianDistance(double[] point1, double[] point2){
        double total = 0.0;
        for(int i=0; i<point1.length; i++) {
            total = total + Math.pow((point1[i]-point2[i]), 2.0);
        }
        return Math.sqrt(total);
    }


}
