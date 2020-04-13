import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        if (args.length == 2) {
            //input data
            ArrayList<String> attributes = DataLoader.readAttributeNames(args[0]);
            Dataset trainingData = new Dataset(DataLoader.readData(args[0]));
            classStats baselinePredictor = trainingData.getMostCommonClass();
            Node rootNode = DecisionTreeLearningAlgorithm.buildTree(trainingData, attributes, baselinePredictor);

            Dataset testData = new Dataset(DataLoader.readData(args[1]));
            for(DatasetInstance i: testData.getData()){
                rootNode.testData(i);
            }
            //rootNode.report("   ");
        } else {
            System.out.println("A training dataset and testing dataset are required for this program to run");
        }

    }

}
