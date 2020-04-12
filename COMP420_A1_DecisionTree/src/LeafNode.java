public class LeafNode extends Node {

    private String className;
    private Double probability;

    public LeafNode(String className, Double probability) {
        this.className = className;
        this.probability = probability;
    }
}
