public class LeafNode implements Node {

    private String className;
    private double probability;

    public LeafNode(String className, Double probability) {
        this.className = className;
        this.probability = probability;
    }

    @Override
    public void report(String indent){
        //if (count==0)
            //System.out.format("%sUnknown\n", indent);
        //else
            System.out.format("%sClass %s, prob=%f\n",
                    indent, className, probability);
    }

    @Override
    public void testData(DatasetInstance instance) {
        System.out.println("Predicted Class: "+className+"\nActual Class: "+instance.getInstanceClass()+"\nProbability: "+probability+"\n-----------");
    }

}
