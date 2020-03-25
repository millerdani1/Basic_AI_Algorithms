import java.util.ArrayList;

//class for calculating and storing range values for data
public class RangeData {
    private Double[] range;
    private Double[] minValues;
    private Double[] maxValues;

    public Double[] getRange() {
        return range;
    }

    public Double[] getMinValues() {
        return minValues;
    }

    public Double[] getMaxValues() {
        return maxValues;
    }

    //calculates range of data
    public RangeData(ArrayList<WineObject> arr) {
        int numOfAttributes = arr.get(0).getAttributes().length;
        this.minValues = new Double[numOfAttributes];
        this.maxValues = new Double[numOfAttributes];

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < numOfAttributes; j++) {

                if (minValues[j] == null || minValues[j] > arr.get(i).getAttributes()[j]) {
                    minValues[j] = arr.get(i).getAttributes()[j];
                }

                if (maxValues[j] == null || maxValues[j] < arr.get(i).getAttributes()[j]) {
                    maxValues[j] = arr.get(i).getAttributes()[j];
                }
            }
        }
        this.range = new Double[numOfAttributes];
        for (int i = 0; i < numOfAttributes; i++) {
            range[i] = maxValues[i] - minValues[i];
        }

    }

}
