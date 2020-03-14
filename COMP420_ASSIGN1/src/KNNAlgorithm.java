import java.util.*;

public class KNNAlgorithm {

    public static void runAlgorithm(ArrayList<WineTestObject> training, ArrayList<WineTestObject> test, int kValue){

        //for all points in the test data
        for(int i = 0; i<1; i++){
            List<Map<Double, Integer>> list = new ArrayList<Map<Double, Integer>>();
            //find distance to each training point and store in sorted list
            for(int j = 0; j<training.size();j++){
                Map<Double, Integer> map = new HashMap<Double, Integer>();
                map.put(calculateEuclidianDistance(test.get(i).getAttributes(), training.get(j).getAttributes()), training.get(j).getWineClass());
                list.add(map);
            }
            //choose first k points

            //assign class to

            Collections.sort(list, new Comparator<Map<Double, Integer>>() {
                public int compare(Map<Double, Integer> o1, Map<Double, Integer> o2) {
                    Collection<Double> values1 = o1.keySet();
                    Collection<Double> values2 = o2.keySet();
                    if(!values1.isEmpty() && !values2.isEmpty()){
                        return values1.iterator().next().compareTo(values2.iterator().next());
                    }else{
                        return 0;
                    }
                }
            });








            for(int h =0;h<list.size();h++){
                System.out.println(list.get(h));
            }
        }







    }

    private static double calculateEuclidianDistance(double[] point1, double[] point2){
        double total = 0.0;
        for(int i=0; i<point1.length; i++) {
            total = total + Math.pow((point1[i]-point2[i]), 2.0);
        }
        return Math.sqrt(total);
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
