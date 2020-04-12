public class BranchNode extends Node {

    private String attribute;
    private Node leftChild;
    private Node rightChild;

    public BranchNode(String attribute, Node leftChild, Node rightChild) {
        this.attribute = attribute;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
