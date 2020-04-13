import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        if (args.length == 2) {
            //load training data and generate tree
            ArrayList<String> attributes = DataLoader.readAttributeNames(args[0]);
            Dataset trainingData = new Dataset(DataLoader.readData(args[0]));
            classStats baselinePredictor = trainingData.getMostCommonClass();
            Node rootNode = DecisionTreeLearningAlgorithm.buildTree(trainingData, attributes, baselinePredictor);

            //print out tree
            System.out.println("Tree Visualisation:\n");
            rootNode.report("   ");
            System.out.println("");

            //print predicted classes
            Dataset testData = new Dataset(DataLoader.readData(args[1]));
            System.out.println("predicted Classes");
            for (DatasetInstance i : testData.getData()) {
                rootNode.testData(i);
            }

        } else {
            System.out.println("A training dataset and testing dataset are required for this program to run");
        }

    }

}
