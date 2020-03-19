import java.util.*;

public class KNNAlgorithm {

    public static void runAlgorithm(ArrayList<WineObject> training, ArrayList<WineObject> test, int kValue, Double[] trainingRanges) {

        //ensure kvalue is within bounds
        if (kValue < 1 || kValue > training.size()) {
            System.out.println("K value must be between 1 and " + training.size() + " (training dataset size)");
            System.exit(0);
        }

        int correct = 0; //track correct number of predictions

        //for all points in the test data
        for (int i = 0; i < test.size(); i++) {

            //find distance to each training point and store in sorted list
            List<PointDistance> distanceList = new ArrayList<PointDistance>();
            for (int j = 0; j < training.size(); j++) {
                distanceList.add(new PointDistance(calculateEuclidianDistance(test.get(i).getAttributes(), training.get(j).getAttributes(), trainingRanges), training.get(j).getWineClass()));
            }
            Collections.sort(distanceList);

            //choose first k points
            int[] classFrequencyArray = new int[kValue];
            for (int q = 0; q < kValue; q++) {
                classFrequencyArray[q] = distanceList.get(q).getWineClass();
            }
            //assign class to point
            int prediction = calculateMostFrequentClass(classFrequencyArray);
            if (prediction == test.get(i).getWineClass()) correct++;
            System.out.println("Instance " + (i + 1) + "= predicted: " + prediction + " Actual: " + test.get(i).getWineClass());

        }
        //print out ratio & % of correct predictions
        int total = test.size();
        double percent = ((double) correct / (double) total) * 100.0;
        System.out.println("For K value: " + kValue);
        System.out.println(correct + "/" + total + " correct, or " + percent + "%");

    }

    //calculates most frequent class
    private static int calculateMostFrequentClass(int[] inputArray) {
        if (inputArray.length == 1) return inputArray[0];

        HashMap<Integer, Integer> classCount = new HashMap<Integer, Integer>();//key=class, value=frequency
        //counting the number of times each class occurs
        for (int i : inputArray) {
            if (classCount.containsKey(i)) classCount.put(i, classCount.get(i) + 1);
            else classCount.put(i, 1);
        }

        int wineClass = 0;
        int frequency = 1;

        //Iterating through class frequencies to get most frequent class
        Set<Map.Entry<Integer, Integer>> set = classCount.entrySet();

        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() > frequency) {
                wineClass = entry.getKey();
                frequency = entry.getValue();
            }
        }
        return wineClass;
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
