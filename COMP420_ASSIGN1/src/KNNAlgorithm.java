import java.util.*;

public class KNNAlgorithm {

    public static void runAlgorithm(ArrayList<WineTestObject> training, ArrayList<WineTestObject> test, int kValue){
        int correct=0;
        int incorrect=0;

        //for all points in the test data
        for(int i = 0; i<test.size(); i++){

            //find distance to each training point and store in sorted list
            List<PointDistance> distanceList = new ArrayList<PointDistance>();
            for(int j = 0; j<training.size();j++){
                distanceList.add(new PointDistance(calculateEuclidianDistance(test.get(i).getAttributes(), training.get(j).getAttributes()), training.get(j).getWineClass()));
            }
            Collections.sort(distanceList);

            //choose first k points
            int[] classFrequencyArray = new int[kValue];
            for(int q = 0; q <kValue; q++){
                classFrequencyArray[q] = distanceList.get(q).getWineClass();
            }
            //assign class to point
            int yeet =calculateMostFrequentClass(classFrequencyArray);
            if(yeet==test.get(i).getWineClass()) correct++;
            else incorrect++;
            System.out.println("predicted: "+yeet+" Actual: "+ test.get(i).getWineClass());

        }
        int total = correct+incorrect;
        double percent = ((double)correct/(double)total)*100.0;
        System.out.println(correct+"/"+total+" correct, or " + percent+"%");

    }

    //calculates most frequent class
    private static int calculateMostFrequentClass(int[] inputArray){

        HashMap<Integer, Integer> classCount = new HashMap<Integer, Integer>();//key=class, value=frequency
        //counting the number of times each class occurs
        for (int i : inputArray){
            if (classCount.containsKey(i)) classCount.put(i, classCount.get(i)+1);
            else classCount.put(i, 1);
        }

        int wineClass = 0;
        int frequency = 1;

        //Iterating through class frequencies to get most frequent class
        Set<Map.Entry<Integer, Integer>> set = classCount.entrySet();

        for (Map.Entry<Integer, Integer> entry : set){
            if(entry.getValue() > frequency){
                wineClass = entry.getKey();
                frequency = entry.getValue();
            }
        }
        return wineClass;
    }

    //calculates Euclidian distance between n dimensional vectors
    private static double calculateEuclidianDistance(double[] point1, double[] point2){
        double total = 0.0;
        for(int i=0; i<point1.length; i++) {
            total = total + Math.pow((point1[i]-point2[i]), 2.0);
        }
        return Math.sqrt(total);
    }


}
