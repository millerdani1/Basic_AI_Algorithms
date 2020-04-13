public class BranchNode implements Node {

    private String attribute;
    private Node leftChild;
    private Node rightChild;

    public BranchNode(String attribute, Node leftChild, Node rightChild) {
        this.attribute = attribute;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public void report(String indent){
        System.out.format("%s%s = True:\n",
                indent, attribute);
        leftChild.report(indent+" ");
        System.out.format("%s%s = False:\n",
                indent, attribute);
        rightChild.report(indent+" ");
    }

    @Override
    public void testData(DatasetInstance instance) {
        if(instance.getAttributes().get(attribute) == true)
            leftChild.testData(instance);
        else
            rightChild.testData(instance);
    }
}
