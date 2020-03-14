import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class WineDataLoader {

    //takes wine data file and returns ArrayList of WineInstance objects
    public ArrayList readWineData(String filePath) {
        ArrayList<WineInstance> arr = new ArrayList<WineInstance>();
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
    private WineInstance generateWineInstance(String data){

        String[] split = data.split("\\s+");

        if(split.length!=14){
            System.out.println("bad line found in file");
            return null;
        }

        return new WineInstance(
                Double.parseDouble(split[0]), Double.parseDouble(split[1]),
                Double.parseDouble(split[2]), Double.parseDouble(split[3]),
                Double.parseDouble(split[4]), Double.parseDouble(split[5]),
                Double.parseDouble(split[6]), Double.parseDouble(split[7]),
                Double.parseDouble(split[8]), Double.parseDouble(split[9]),
                Double.parseDouble(split[10]), Double.parseDouble(split[11]),
                Double.parseDouble(split[12]), Integer.parseInt(split[13]));
    }
}