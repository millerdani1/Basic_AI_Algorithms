import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        Main m = new Main(args);
    }

    public Main(String args[]) {

        int kValue = 2;
        if (args.length == 3) {

            //ensure input k value is valid int
            try {
                kValue = Integer.parseInt(args[2].trim());
            } catch (NumberFormatException e) {
                System.out.println("K value must be valid int");
                System.exit(0);

            }
        }

        if (args.length == 2 || args.length == 3) {

            ArrayList<WineObject> trainingData = WineDataLoader.readWineData(args[0]);
            ArrayList<WineObject> testData = WineDataLoader.readWineData(args[0]);

            KMeansAlgorithm.runAlgorithm(trainingData, testData, kValue);
        } else {
            System.out.println("This program requires two file names, and optionally a K value");
        }

    }
}
