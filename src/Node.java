public class Node {



    private Node parentNode;
    private Node smallChild;
    private Node midChild;
    private Node largeChild;
    private Node tempLargestChild;

    private Integer smallKey;
    private Integer largeKey;
    private Integer tempMidKey;





    /**
     * Creates an empty node/child
     */
    public Node(Integer smallKey) {

        this.smallKey = smallKey;
        smallChild = null;
        midChild = null;
        largeChild = null;
        tempLargestChild = null;
    }


     /*
      --------------Mutators------------------
     */


    public void splitNode()
    {
            /**parent has 3 nodes*/
            if (parentNode.getMidChild() != null)
            {

                //this node is the smaller Child
                if (this == parentNode.getSmallChild())
                {
                    parentNode.setTempLargestChild(parentNode.getLargeChild());
                    parentNode.setLargeChild(parentNode.getMidChild());

                    Node newSmallChild = new Node(smallKey);
                    newSmallChild.setSmallChild(smallChild);
                    newSmallChild.setLargeChild(midChild);
                    newSmallChild.setParentNode(parentNode);
                    parentNode.setSmallChild(newSmallChild);


                    Node newMidChild = new Node(largeKey);
                    newSmallChild.setSmallChild(largeChild);
                    newSmallChild.setLargeChild(tempLargestChild);
                    newMidChild.setParentNode(parentNode);
                    parentNode.setMidChild(newMidChild);
                    return;

                }
                //this is the Mid Child
                else if (this == parentNode.getMidChild())
                {

                    parentNode.setTempLargestChild(parentNode.getLargeChild());



                    Node newMidChild = new Node(smallKey);
                    newMidChild.setSmallChild(smallChild);
                    newMidChild.setLargeChild(midChild);
                    newMidChild.setParentNode(parentNode);
                    parentNode.setMidChild(newMidChild);


                    Node newLargeChild = new Node(largeKey);
                    newLargeChild.setSmallChild(largeChild);
                    newLargeChild.setLargeChild(tempLargestChild);
                    newLargeChild.setParentNode(parentNode);
                    parentNode.setLargeChild(newLargeChild);

                    return;
                }
                //this is the Largest Child


                Node newLargeChild = new Node(smallKey);
                newLargeChild.setSmallChild(smallChild);
                newLargeChild.setLargeChild(midChild);
                newLargeChild.setParentNode(parentNode);
                parentNode.setLargeChild(newLargeChild);

                Node newTempLargestChild = new Node(largeKey);
                newTempLargestChild.setSmallChild(largeChild);
                newTempLargestChild.setLargeChild(tempLargestChild);
                newTempLargestChild.setParentNode(parentNode);
                parentNode.setTempLargestChild(newTempLargestChild);

                return;
            }

            /**parent has 2 children*/

                //this is the smaller child

                if (this == parentNode.getSmallChild()) {

                    Node newSmallChild = new Node(smallKey);

                    newSmallChild.setParentNode(parentNode);
                    newSmallChild.setSmallChild(smallChild);
                    newSmallChild.setLargeChild(midChild);
                    parentNode.setSmallChild(newSmallChild);

                    Node newMidChild = new Node(largeKey);
                    newMidChild.setSmallChild(largeChild);
                    newMidChild.setLargeChild(tempLargestChild);
                    newMidChild.setParentNode(parentNode);
                    parentNode.setMidChild(newMidChild);

                    return;
                }
                //this is the large child
                Node newMidChild = new Node(smallKey);
                newMidChild.setSmallChild(smallChild);
                newMidChild.setLargeChild(midChild);
                newMidChild.setParentNode(parentNode);
                parentNode.setMidChild(newMidChild);

                Node newLargeChild = new Node(largeKey);
                newLargeChild.setSmallChild(largeChild);
                newLargeChild.setLargeChild(tempLargestChild);
                newLargeChild.setParentNode(parentNode);
                parentNode.setLargeChild(newLargeChild);
                return;

        }





    public void promoteTempMidKey()
    {


        if(parentNode.has1Key())
        {
            parentNode.setLargeKey(tempMidKey);
            tempMidKey = null;
            return;
        }


        parentNode.setTempMidKey(tempMidKey);
        tempMidKey = null;

    }

    /*
      ----------------------------------------
     */


    /*
      -------------- Getters------------------
     */
    public Node getLargeChild() {

        return largeChild;
    }


    public Node getParentNode()
    {
        return this.parentNode;
    }


    public Node getTempLargestChild() {
        return tempLargestChild;
    }


    public Node getSmallChild() {

        return smallChild;
    }


    public Node getMidChild() {

        return midChild;
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

        if (val < this.smallKey)
        {
            this.largeKey = this.smallKey;
            this.smallKey = val;
            return;
        }

        this.largeKey = val;
    }


    public void setSmallChild(Node smallChild) {

        this.smallChild = smallChild;
    }


    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }


    public void setMidChild(Node midChild) {

        this.midChild = midChild;
    }

    // finds and stores the midChild value key by storing it in temp key based on input value
    public void setTempMidKey(Integer tempMidKey)
    {

        if (tempMidKey > this.largeKey)
            {

                this.tempMidKey = largeKey;
                largeKey = tempMidKey;

            }
            else if (tempMidKey < this.smallKey)
            {
                this.tempMidKey = smallKey;
                smallKey = tempMidKey;


            }
            else
                {

                this.tempMidKey = tempMidKey;
                }

            return;

    }


    public void setTempLargestChild(Node tempLargestChild) {
        this.tempLargestChild = tempLargestChild;
    }


    public void setLargeChild(Node largeChild) {

        this.largeChild = largeChild;
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

        return smallChild == null && midChild == null && largeChild == null;
    }

    public boolean has1Key() {

        return largeKey == null; // also, largeChild node is null but this will be always true if largeKey == null
    }

    public boolean has2Keys() {

        return largeKey != null; // also, largeChild node is not null but this will be always true if largeKey <> null
    }

    public boolean has3Keys()
    {
        return largeKey != null && tempMidKey != null;
    }

    public  boolean hasElement()
    {
        return true;
    }
    /*
      ----------------------------------------
     */


}