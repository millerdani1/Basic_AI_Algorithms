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
        if(this.data.isEmpty()) return 0.0;//dunno if this is the correct way of dealing with this
        //count num of correctly classified instances
        int correctNum = 0;
        for(DatasetInstance i: this.data){
            if(i.getWillLive() == correct) correctNum++;
        }
        int incorrectNum=this.data.size()-correctNum;
        return 1 - Math.pow(correctNum/this.data.size(), 2.0) - Math.pow(incorrectNum/this.data.size(), 2.0);
    }

    //checks if all instances in a set have the same class (set is pure)
    public boolean isPure() {
        for (int i = 1; i < this.data.size(); i++) {
            if (this.data.get(i).getWillLive() != this.data.get(0).getWillLive()) return false;
        }
        return true;
    }
}
