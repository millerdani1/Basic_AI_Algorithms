import java.util.ArrayList;

public class Node {
    private String attribute;
    private Node leftChild;
    private Node rightChild;

    public Node(String attribute, Node leftChild, Node rightChild) {
        this.attribute = attribute;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
