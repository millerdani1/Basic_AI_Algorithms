import java.util.ArrayList;
import java.util.HashMap;

public class DatasetInstance {

    private HashMap<String, Boolean> attributes;
    private String instanceClass;

    public DatasetInstance(HashMap<String, Boolean> attributes, String instanceClass) {
        this.attributes = attributes;
        this.instanceClass = instanceClass;
    }

    public HashMap<String, Boolean> getAttributes() {
        return attributes;
    }

    public String getInstanceClass() {
        return instanceClass;
    }
}
