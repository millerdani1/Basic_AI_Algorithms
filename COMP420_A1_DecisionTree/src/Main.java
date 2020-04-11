import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String args[]) {

        if (args.length == 2) {
            //input data
            ArrayList<String> attributes = DataLoader.readAttributeNames(args[0]);
            Dataset trainingData = new Dataset(DataLoader.readData(args[1]));//need to change back to 0
            //Dataset testData = new Dataset(DataLoader.readData(args[1]));
            Node rootNode = DecisionTreeLearningAlgorithm.buildTree(trainingData, attributes);

        } else {
            System.out.println("A training dataset and testing dataset are required fro this program to run");
        }

    }

}
