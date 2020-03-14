import java.util.ArrayList;

public class Main {

    public static void main(String args[]){
        Main m = new Main(args);
    }

    public Main(String args[]){

        if(args.length == 2) {
            KNNAlgorithm.runAlgorithm(WineDataLoader.readWineData(args[0]), WineDataLoader.readWineData(args[1]), 2);

        } else {
            System.out.println("Two input files are required to run this program");
        }

    }
}
