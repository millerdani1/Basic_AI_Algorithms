import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        if(args.length==2) {
            //input data
            ArrayList<DatasetInstance> trainingData = DataLoader.readData(args[0]);
            ArrayList<DatasetInstance> testData = DataLoader.readData(args[1]);
        } else {
            System.out.println("A training dataset and testing dataset are required fro this program to run");
        }

    }


}
