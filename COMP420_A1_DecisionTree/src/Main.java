import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        //input data

        ArrayList<DatasetInstance> trainingData = DataLoader.readData(args[0]);
        ArrayList<DatasetInstance> testData = DataLoader.readData(args[0]);
    }


}
