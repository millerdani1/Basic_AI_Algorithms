import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataLoader {

    //iterates through data and returns list of instance objects
    public static ArrayList readData(String filePath) {
        ArrayList<DatasetInstance> arr = new ArrayList<DatasetInstance>();
        ArrayList<String> attributeNames;
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            attributeNames = formatAttributeNames(scanner.nextLine());

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                arr.add(generateInstance(data, attributeNames));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file '" + filePath + "' could not be found");
            System.exit(0);
        }
        return arr;
    }

    //gets an array of different attributes from first line of file
    public static ArrayList formatAttributeNames(String data) {
        ArrayList<String> list = new ArrayList<String>();
        String[] split = data.split("\\s+");
        for (int i = 1; i < split.length; i++) {//include all values except first (class header)
            list.add(split[i]);
        }
        return list;
    }

    //converts string of data into instance objects
    private static DatasetInstance generateInstance(String data, ArrayList<String> attributeNames) {

        String[] split = data.split("\\s+");

        HashMap<String, Boolean> attributes = new HashMap<String, Boolean>();
        for (int i = 1; i < split.length; i++) {
            if (split[i].equals("true")) attributes.put(attributeNames.get(i - 1), true);
            else if (split[i].equals("false")) attributes.put(attributeNames.get(i - 1), false);
            else {
                System.out.println("Found value in attribute data != to true or false");
                System.exit(0);
            }
        }
        boolean willLive = false;
        if (split[0].equals("live")) willLive = true;
        else if (split[0].equals("die")) willLive = false;
        else {
            System.out.println("Found value in class data != to live or die");
            System.exit(0);
        }

        return new DatasetInstance(attributes, willLive);
    }
}
