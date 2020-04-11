import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DecisionTreeLearningAlgorithm {

    public static void runAlgorithm() {

    }

    public static Node buildTree(Dataset instances, ArrayList<String> attributes) {

        if (instances.getData().isEmpty()) {

        }
        if (checkIsPure(instances.getData())) {

        }
        if (attributes.isEmpty()) {

        } else {
            //gets initial attribute purity to measure against
            String bestAttribute = attributes.get(0);
            Dataset bestInstsTrue = getAttribteInstances(instances, true, bestAttribute);
            Dataset bestInstsFalse = getAttribteInstances(instances, false, bestAttribute);
            Double bestAttributePurity = getWeightedPurity(bestInstsTrue, bestInstsFalse);
            for (int i = 1; i < attributes.size(); i++) { //for each attribute
                //separate instances into two sets
                Dataset attributesTrue = getAttribteInstances(instances, true, attributes.get(i));
                Dataset attributesFalse = getAttribteInstances(instances, false, attributes.get(i));
                Double purity = getWeightedPurity(attributesTrue, attributesFalse);

                //if weighted average purity of these sets is best so far
                if (purity < bestAttributePurity) {
                    bestAttribute = attributes.get(i);
                    bestInstsTrue = attributesTrue;
                    bestInstsFalse = attributesFalse;
                    bestAttributePurity = purity;
                }

            }
            //create child nodes
            ArrayList<String> newAttributes = removeBestAttribute(attributes, bestAttribute);
            Node left = buildTree(bestInstsTrue, newAttributes);
            Node right = buildTree(bestInstsFalse, newAttributes);
            //create Node
            return new Node(bestAttribute, left ,right);
        }
        return null;
    }


    private static Dataset getAttribteInstances(Dataset instances, boolean isTrue, String attribute) {
        ArrayList<DatasetInstance> newArr = new ArrayList<DatasetInstance>();
        for (DatasetInstance instance : instances.getData()) {
            if (instance.getAttributes().get(attribute) == isTrue) {
                newArr.add(instance);
            }
        }
        return new Dataset(newArr);
    }

    //checks if all instances in a set have the same class (set is pure)
    private static boolean checkIsPure(ArrayList<DatasetInstance> instances) {
        for (int i = 1; i < instances.size(); i++) {
            if (instances.get(i).getWillLive() != instances.get(0).getWillLive()) return false;
        }
        return true;
    }

    private static Double getWeightedPurity(Dataset attributesTrue, Dataset attributesFalse) {
        int total = attributesTrue.getData().size()+attributesFalse.getData().size();
        return ((attributesTrue.getData().size()/total) * attributesTrue.calculatePurity(true)) + ((attributesFalse.getData().size()/total) * attributesFalse.calculatePurity(false));
    }



    private static ArrayList<String> removeBestAttribute(ArrayList<String> attributes, String bestAttribute){
        ArrayList<String> arr = attributes;
        arr.remove(bestAttribute);
        return arr;
    }


}
