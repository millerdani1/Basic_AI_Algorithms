import java.util.ArrayList;

public class DecisionTreeLearningAlgorithm {

    public static Node buildTree(Dataset instances, ArrayList<String> attributes, classStats baselinePredictor) {

        if (instances.getData().isEmpty()) {
            return new LeafNode(baselinePredictor.getName(), baselinePredictor.getProbability());
        }
        if (instances.calculatePurity() == 0.0) {
            return new LeafNode(instances.getData().get(0).getInstanceClass(), 1.0);
        }
        if (attributes.isEmpty()) {
            classStats mostCommonClass = instances.getMostCommonClass();
            return new LeafNode(mostCommonClass.getName(), mostCommonClass.getProbability());
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
            Node left = buildTree(bestInstsTrue, newAttributes, baselinePredictor);
            Node right = buildTree(bestInstsFalse, newAttributes, baselinePredictor);
            //create Node
            return new BranchNode(bestAttribute, left, right);
        }
    }

    //returns arraylist of instances with the same boolean value of a specific attribute
    private static Dataset getAttribteInstances(Dataset instances, boolean isTrue, String attribute) {
        ArrayList<DatasetInstance> newArr = new ArrayList<DatasetInstance>();
        for (DatasetInstance instance : instances.getData()) {
            if (instance.getAttributes().get(attribute) == isTrue) {
                newArr.add(instance);
            }
        }
        return new Dataset(newArr);
    }

    //calculates weighted purity of two Datasets
    private static Double getWeightedPurity(Dataset attributesTrue, Dataset attributesFalse) {
        double totalSize = attributesTrue.getData().size() + attributesFalse.getData().size();
        double trueWeight = attributesTrue.getData().size() / totalSize;
        double falseWeight = attributesFalse.getData().size() / totalSize;

        return trueWeight * attributesTrue.calculatePurity() + falseWeight * attributesFalse.calculatePurity();

    }

    //takes an Arraylist of attributes and a attribute, then returns a new Arraylist with that specified attribute removed
    private static ArrayList<String> removeBestAttribute(ArrayList<String> attributes, String bestAttribute) {
        ArrayList<String> tempArr = new ArrayList(attributes);
        tempArr.remove(bestAttribute);
        return tempArr;
    }
}
