import java.util.ArrayList;

public class DatasetInstance {

    private boolean[] attributes;
    private boolean willLive;

    public DatasetInstance(boolean[] attributes, boolean willLive){
        this.attributes=attributes;
        this.willLive=willLive;
    }

    public boolean[] getAttributes() {
        return attributes;
    }

    public boolean getWillLive() {
        return willLive;
    }
}
