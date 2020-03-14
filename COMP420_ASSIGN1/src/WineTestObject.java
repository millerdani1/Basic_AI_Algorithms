public class WineTestObject {

    private double[] attributes;
    private int wineClass;

    public WineTestObject(double[] attributes, int wineClass) {

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
