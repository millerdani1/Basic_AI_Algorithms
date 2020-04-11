import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DecisionTreeLearningAlgorithm {

    public static void runAlgorithm() {

    }

    public static Node buildTree(ArrayList<DatasetInstance> instances, ArrayList<String> attributes) {

        if (instances.isEmpty()) {

        }
        if (checkIsPure(instances)) {

        }
        if (attributes.isEmpty()) {

        } else {
            //gets initial attribute purity to measure against
            String bestAttribute = attributes.get(0);
            ArrayList<DatasetInstance> bestInstsTrue = getAttribteInstances(instances, true, bestAttribute);
            ArrayList<DatasetInstance> bestInstsFalse = getAttribteInstances(instances, false, bestAttribute);
            Double bestAttributePurity = getWeightedPurity(bestInstsTrue, bestInstsFalse);
            for (int i = 1; i < attributes.size(); i++) { //for each attribute
                //separate instances into two sets
                ArrayList<DatasetInstance> attributesTrue = getAttribteInstances(instances, true, attributes.get(i));
                ArrayList<DatasetInstance> attributesFalse = getAttribteInstances(instances, false, attributes.get(i));
                Double purity = getWeightedPurity(attributesTrue, attributesFalse);

                //if weighted average purity of these sets is best so far
                if (purity < bestAttributePurity) {
                    bestAttribute = attributes.get(i);
                    bestInstsTrue = attributesTrue;
                    bestInstsFalse = attributesFalse;
                    bestAttributePurity = purity;
                }

            }

        }
        return null;
    }


    private static ArrayList getAttribteInstances(ArrayList<DatasetInstance> instances, boolean isTrue, String attribute) {
        ArrayList<DatasetInstance> newArr = new ArrayList<DatasetInstance>();
        for (DatasetInstance instance : instances) {
            if (instance.getAttributes().get(attribute) == isTrue) {
                newArr.add(instance);
            }
        }
        return newArr;
    }

    //checks if all instances in a set have the same class (set is pure)
    private static boolean checkIsPure(ArrayList<DatasetInstance> instances) {
        for (int i = 1; i < instances.size(); i++) {
            if (instances.get(i).getWillLive() != instances.get(0).getWillLive()) return false;
        }
        return true;
    }

    private static Double getWeightedPurity(ArrayList<DatasetInstance> attributesTrue, ArrayList<DatasetInstance> attributesFalse) {
        int total = attributesTrue.size()+attributesFalse.size();
        return ((attributesTrue.size()/total) * calculatePurity(attributesTrue, true)) + ((attributesFalse.size()/total) * calculatePurity(attributesFalse, false));
    }

    private static  Double calculatePurity(ArrayList<DatasetInstance> instances, boolean correct){
        //count num of correctly classified instances
        int correctNum = 0;
        for(DatasetInstance i: instances){
            if(i.getWillLive() == correct) correctNum++;
        }
        int incorrectNum=instances.size()-correctNum;
        return 1 - Math.pow(correctNum/instances.size(), 2.0) - Math.pow(incorrectNum/instances.size(), 2.0);
    }


}
