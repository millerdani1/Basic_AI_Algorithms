import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DecisionTreeLearningAlgorithm {

    public static void runAlgorithm() {

    }

    public static Node buildTree(ArrayList<DatasetInstance> instances, HashMap<Integer, String> attributes) {

        if (instances.isEmpty()) {

        }
        if (checkIsPure(instances)) {

        }
        if (attributes.isEmpty()) {

        } else {
            //String bestAttName;
            int bestAttIndex;
            ArrayList<DatasetInstance> bestInstsTrue;
            ArrayList<DatasetInstance> bestInstsFalse;
            for (Integer i : attributes.keySet()) { //for each attribute
                //separate instances into two sets
                ArrayList<DatasetInstance> attributesTrue = new ArrayList<DatasetInstance>();
                ArrayList<DatasetInstance> attributesFalse = new ArrayList<DatasetInstance>();
                checkPurity(attributesTrue, attributesFalse);

            }

        }
        return null;
    }

    //checks if all instances in a set have the same class (set is pure)
    private static boolean checkIsPure(ArrayList<DatasetInstance> instances) {
        for (int i = 1; i < instances.size(); i++) {
            if (instances.get(i).getWillLive() != instances.get(0).getWillLive()) return false;
        }
        return true;
    }

    private static void checkPurity(ArrayList<DatasetInstance> attributesTrue, ArrayList<DatasetInstance> attributesFalse){

    }

}
