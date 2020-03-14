import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class WineDataLoader {



    public void readWineData(String filePath) {
        try {
            File wineFile = new File(filePath);
            Scanner scanner = new Scanner(wineFile);
            scanner.nextLine();//skips first line
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                //System.out.println(data);
                generateWineInstance(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void generateWineInstance(String data){

    }
}