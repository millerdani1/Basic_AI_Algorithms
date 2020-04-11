import java.util.ArrayList;

public class Dataset {

    private ArrayList<DatasetInstance> data;

    public ArrayList<DatasetInstance> getData() {
        return data;
    }

    public Dataset(ArrayList<DatasetInstance> instances) {
        this.data = instances;
    }

    public Double calculatePurity(boolean correct){
        //count num of correctly classified instances
        int correctNum = 0;
        for(DatasetInstance i: this.data){
            if(i.getWillLive() == correct) correctNum++;
        }
        int incorrectNum=this.data.size()-correctNum;
        return 1 - Math.pow(correctNum/this.data.size(), 2.0) - Math.pow(incorrectNum/this.data.size(), 2.0);
    }
}
