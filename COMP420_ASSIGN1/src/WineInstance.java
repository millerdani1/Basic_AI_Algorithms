public class WineInstance {

    private double attribute1; //Alcohol
    private double attribute2; //Malic_acid
    private double attribute3; //Ash
    private double attribute4; //Alcalinity_of_ash
    private double attribute5; //Magnesium
    private double attribute6; //Total_phenols
    private double attribute7; //Flavanoids
    private double attribute8; //Nonflavanoid_phenols
    private double attribute9; //Proanthocyanins
    private double attribute10; //Color_intensity
    private double attribute11; //Hue
    private double attribute12; //OD280%2FOD315_of_diluted_wines
    private double attribute13; //Proline

    private int wineClass;

    public WineInstance(
            double attribute1, double attribute2, double attribute3,
            double attribute4, double attribute5, double attribute6,
            double attribute7, double attribute8, double attribute9,
            double attribute10, double attribute11, double attribute12,
            double attribute13, int wineClass) {

        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.attribute6 = attribute6;
        this.attribute7 = attribute7;
        this.attribute8 = attribute8;
        this.attribute9 = attribute9;
        this.attribute10 = attribute10;
        this.attribute11 = attribute11;
        this.attribute12 = attribute12;
        this.attribute13 = attribute13;
        this.wineClass = wineClass;
    }

    public double getAttribute1() {
        return attribute1;
    }

    public double getAttribute2() {
        return attribute2;
    }

    public double getAttribute3() {
        return attribute3;
    }

    public double getAttribute4() {
        return attribute4;
    }

    public double getAttribute5() {
        return attribute5;
    }

    public double getAttribute6() {
        return attribute6;
    }

    public double getAttribute7() {
        return attribute7;
    }

    public double getAttribute8() {
        return attribute8;
    }

    public double getAttribute9() {
        return attribute9;
    }

    public double getAttribute10() {
        return attribute10;
    }

    public double getAttribute11() {
        return attribute11;
    }

    public double getAttribute12() {
        return attribute12;
    }

    public double getAttribute13() {
        return attribute13;
    }

    public int getWineClass() {
        return wineClass;
    }
}
