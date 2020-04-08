import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {



    public static ArrayList readData(String filePath) {
        ArrayList<DatasetInstance> arr = new ArrayList<DatasetInstance>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();//skips first line

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                arr.add(generateInstance(data));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return arr;
    }

    //converts string of wine data and converts it into WineInstance object
    private static DatasetInstance generateInstance(String data) {

        String[] split = data.split("\\s+");

        boolean[] attributes = new boolean[split.length-1];
        for (int i = 1; i < split.length; i++) {
            if(split[i].equals("true")) attributes[i-1] = true;
            else if(split[i].equals("false")) attributes[i-1] = false;
            else{
                System.out.println("Found value in attribute data != to true or false");
                System.exit(0);
            }
        }
        boolean willLive =false;
        if(split[0].equals("live")) willLive=true;
        else if (split[0].equals("die")) willLive=false;
        else{
            System.out.println("Found value in class data != to live or die");
            System.exit(0);
        }

        return new DatasetInstance(attributes, willLive);
    }
}
