import java.util.*;

public class Dataset {

    private ArrayList<DatasetInstance> data;

    public ArrayList<DatasetInstance> getData() {
        return data;
    }

    public Dataset(ArrayList<DatasetInstance> instances) {
        this.data = instances;
    }

    public Double calculatePurity(String instanceClass) {
        if (this.data.isEmpty()) return 0.0;//dunno if this is the correct way of dealing with this
        //count num of correctly classified instances
        int correctNum = 0;
        for (DatasetInstance i : this.data) {
            if (i.getInstanceClass().equals(instanceClass)) correctNum++;
        }
        int incorrectNum = this.data.size() - correctNum;
        return 1 - Math.pow(correctNum / this.data.size(), 2.0) - Math.pow(incorrectNum / this.data.size(), 2.0);
    }

    //checks if all instances in a set have the same class (set is pure)
    public boolean isPure() {
        for (int i = 1; i < this.data.size(); i++) {
            if (this.data.get(i).getInstanceClass().equals(this.data.get(0).getInstanceClass())) return false;
        }
        return true;
    }

    //returns datasets most common class and its probability
    public classStats getMostCommonClass() {
        Map<String, Integer> count = new HashMap<>();

        //count number of occourences of each class
        for (DatasetInstance instance : this.data) {
            String word = instance.getInstanceClass();

            if (!count.containsKey(word)) {
                count.put(word, 1);
            } else {
                int value = count.get(word);
                value++;
                count.put(word, value);
            }
        }

        //get class which occoured the most
        Map.Entry<String, Integer> mostRepeated = null;
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            if (mostRepeated == null || mostRepeated.getValue() < e.getValue())
                mostRepeated = e;
        }

        //calculate classes probability and return the data
        double probability = (double) mostRepeated.getValue() / (double) this.data.size();
        return new classStats(mostRepeated.getKey(), probability);

    }

}


//class for returning this datasets most common class and probability with the same method
class classStats {
    private String name;
    private double probability;

    public classStats(String name, double probability) {
        this.name = name;
        this.probability = probability;
    }

    public String getName() {
        return name;
    }

    public Double getProbability() {
        return probability;
    }
}
