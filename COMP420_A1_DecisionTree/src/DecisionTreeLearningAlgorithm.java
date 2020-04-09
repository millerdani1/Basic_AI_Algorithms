import java.util.ArrayList;
import java.util.HashMap;

public class DecisionTreeLearningAlgorithm {

    public static void runAlgorithm() {

    }

    public static void buildTree(ArrayList<DatasetInstance> instances, HashMap<Integer, String> attributes) {

        if (instances.isEmpty()) {

        }
        if (checkIsPure(instances)) {

        }
        if (attributes.isEmpty()) {

        } else {


        }

    }

    //checks if all instances in a set have the same class (set is pure)
    private static boolean checkIsPure(ArrayList<DatasetInstance> instances) {
        for (int i = 1; i < instances.size(); i++) {
            if (instances.get(i).getWillLive() != instances.get(0).getWillLive()) return false;
        }
        return true;
    }

}
