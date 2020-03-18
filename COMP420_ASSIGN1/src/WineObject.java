public class WineObject {

    private double[] attributes;
    private int wineClass;

    public WineObject(double[] attributes, int wineClass) {

        this.attributes = attributes;
        this.wineClass = wineClass;
    }

    public double[] getAttributes() {
        return attributes;
    }

    public int getWineClass() {
        return wineClass;
    }
}
