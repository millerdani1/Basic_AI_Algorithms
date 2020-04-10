import java.util.ArrayList;
import java.util.HashMap;

public class DatasetInstance {

    private HashMap<String, Boolean> attributes;
    private boolean willLive;

    public DatasetInstance(HashMap<String, Boolean> attributes, boolean willLive){
        this.attributes=attributes;
        this.willLive=willLive;
    }

    public HashMap<String, Boolean> getAttributes() {
        return attributes;
    }

    public boolean getWillLive() {
        return willLive;
    }
}
