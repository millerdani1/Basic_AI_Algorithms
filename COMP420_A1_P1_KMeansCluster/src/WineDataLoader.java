import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class WineDataLoader {

    //takes wine data file and returns ArrayList of WineInstance objects
    public static ArrayList readWineData(String filePath) {
        ArrayList<WineObject> arr = new ArrayList<WineObject>();
        try {
            File wineFile = new File(filePath);
            Scanner scanner = new Scanner(wineFile);
            scanner.nextLine();//skips first line

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                arr.add(generateWineInstance(data));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return arr;
    }

    //converts string of wine data and converts it into WineInstance object
    private static WineObject generateWineInstance(String data) {

        String[] split = data.split("\\s+");
        if (split.length != 14) {
            System.out.println("Bad line found in file");
            System.exit(0);
        }
        double[] wineAttributes = new double[13];
        for (int i = 0; i < split.length - 1; i++) {
            wineAttributes[i] = Double.parseDouble(split[i]);
        }
        int wineClass = Integer.parseInt(split[13]);

        return new WineObject(wineAttributes, wineClass);
    }



}
