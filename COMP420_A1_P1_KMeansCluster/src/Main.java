import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        Main m = new Main(args);
    }

    public Main(String args[]) {

        int kValue = 2;
        if (args.length == 2) {

            //ensure input k value is valid int
            try {
                kValue = Integer.parseInt(args[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("K value must be valid int");
                System.exit(0);

            }
        }

        if (args.length == 1 || args.length == 2) {

            ArrayList<WineObject> data = WineDataLoader.readWineData(args[0]);

            KMeansAlgorithm.runAlgorithm(data, kValue);
        } else {
            System.out.println("This program requires one file name, and optionally a K value");
        }

    }
}
