import java.util.ArrayList;

public class Main {

    WineDataLoader dataLoader = new WineDataLoader();

    ArrayList<WineInstance> wineTrainingData;
    ArrayList<WineInstance> wineTestData;

    public static void main(String args[]){
        Main m = new Main(args);
    }

    public Main(String args[]){
        wineTrainingData = new ArrayList<WineInstance>();
        wineTestData = new ArrayList<WineInstance>();
        
        if(args.length > 0) {


            dataLoader.readWineData(args[0]);
        }
    }
}
