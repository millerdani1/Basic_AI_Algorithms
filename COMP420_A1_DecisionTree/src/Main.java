import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String args[]) {

        if (args.length == 2) {
            //input data
            HashMap<Integer, String> attributes = DataLoader.readAttributeNames(args[0]);
            ArrayList<DatasetInstance> trainingData = DataLoader.readData(args[0]);
            ArrayList<DatasetInstance> testData = DataLoader.readData(args[1]);
            Node rootNode = DecisionTreeLearningAlgorithm.buildTree(trainingData, attributes);
        } else {
            System.out.println("A training dataset and testing dataset are required fro this program to run");
        }

    }

}
