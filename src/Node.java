public class Node {



    private Node parentNode;
    private Node smallChild;
    private Node midNode;
    private Node largeChild;
    private Node tempLargestNode;

    private Integer smallKey;
    private Integer largeKey;
    private Integer tempMidKey;





    /**
     * Creates an empty node/child
     */
    public Node(Integer smallKey) {

        this.smallKey = smallKey;
        smallChild = null;
        midNode = null;
        largeChild = null;
    }


     /*
      --------------Mutators------------------
     */


    public Node splitNode() {

        if(parentNode.getMidChild() != null)
        {
            Node[] nodeArr = [parentNode.getLeftChild(), parentNode.getMidChild()]
        }





        return parentNode;

    }

    public void promoteTempMidKey() {

    }

    /*
      ----------------------------------------
     */


    /*
      -------------- Getters------------------
     */
    public Node getRightChild() {

        return largeChild;
    }


    public Node getParentNode()
    {
        return this.parentNode;
    }


    public Node getTempLargestNode() {
        return tempLargestNode;
    }


    public Node getLeftChild() {

        return smallChild;
    }


    public Node getMidChild() {

        return midNode;
    }


    public Integer getSmallKey() {

        return smallKey;
    }


    public Integer getTempMidKey() {
        return tempMidKey;
    }


    public Integer getLargeKey() {

        return largeKey;
    }

    /*
      --------------------------------
     */


    /*
      -------------- setters------------------
     */
    public void setSmallKey(int val) {

        if (val > this.smallKey)
        {
            this.largeKey = val;
            return;
        }
        this.smallKey = val;
    }


    public void setLargeKey(int val) {
        System.out.println(val);
        if (val < this.smallKey)
        {
            this.largeKey = this.smallKey;
            this.smallKey = val;
            return;
        }
        this.largeKey = val;
    }


    public void setLeftChild(Node son) {

        this.smallChild = son;
    }


    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }


    public void setMidChild(Node son) {

        this.midNode = son;
    }

    // finds and stores the midNode value key by storing it in temp key based on input value
    public void setTempMidKey(Integer tempMidKey) {
        if(tempMidKey > this.largeKey)
        {

            this.tempMidKey = largeKey;
            largeKey = tempMidKey;

        }
        else if(tempMidKey < this.smallKey)
        {
            this.tempMidKey = smallKey;
            smallKey = tempMidKey;


        }
        else
        {
            this.tempMidKey = tempMidKey;
        }
    }


    public void setTempLargestNode(Node tempLargestNode) {
        this.tempLargestNode = tempLargestNode;
    }


    public void setRightChild(Node son) {

        this.largeChild = son;
    }

    /*
      ---------------------------------------
     */


    /*
      --------------Checkers------------------
     */

    /**
     * @return true if we are on the deepest level of the tree (a leaf) or false if not
     */
    public boolean isLeaf() {

        return smallChild == null && midNode == null && largeChild == null;
    }

    public boolean has1Key() {

        return largeKey == null; // also, largeChild node is null but this will be always true if largeKey == null
    }

    public boolean has2Keys() {

        return largeKey != null; // also, largeChild node is not null but this will be always true if largeKey <> null
    }

    public boolean has3Keys()
    {
        return tempMidKey != null;
    }

    public  boolean hasElement()
    {
        return true;
    }
    /*
      ----------------------------------------
     */


}