import java.util.ArrayList;

public class KNNAlgorithm {

    public static void runAlgorithm(ArrayList<WineTestObject> training, ArrayList<WineTestObject> test, int kValue){

        //for all points in the test data
        for(int i = 0; i<test.size(); i++){



        }







    }








    public static void printListContents(ArrayList<WineTestObject> training, ArrayList<WineTestObject> test){

        //test to make sure everything is here
        System.out.print("There are " + training.size() + " entries in the training list\n");
        for(int i = 0;i<training.size();i++){
            for(int j = 0;j<training.get(i).getAttributes().length;j++){
                System.out.print(training.get(i).getAttributes()[j]);
                System.out.print(" ");
            }
            System.out.print(training.get(i).getWineClass());
            System.out.println("");
        }

        System.out.println("-----------------------------------------------------------");

        System.out.print("There are " + test.size() + " entries in the test list\n");
        for(int i = 0;i<test.size();i++){
            for(int j = 0;j<test.get(i).getAttributes().length;j++){
                System.out.print(test.get(i).getAttributes()[j]);
                System.out.print(" ");
            }
            System.out.print(test.get(i).getWineClass());
            System.out.println("");
        }
    }


}
