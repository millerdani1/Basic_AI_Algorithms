
public class Main {

    WineDataLoader dataLoader = new WineDataLoader();

    public static void main(String args[]){
        Main m = new Main(args);
    }

    public Main(String args[]){
        if(args.length > 0) {


            dataLoader.readWineData(args[0]);
        }
    }
}
