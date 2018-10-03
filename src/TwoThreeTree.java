

public class TwoThreeTree
{

    private Node root;
    private int size;


    public TwoThreeTree ()
    {



    }

    public void printTree()
    {
            System.out.println(root.getLargeChild().getSmallKey() + " " + root.getLargeChild().getLargeKey());
    }

    public void insert(int element)
    {


        if(root == null)
        {
            root = new Node(element);
        }
        else
        {
            insertI(element,root);
        }
    }


    private void insertI(int element, Node currentNode)
    {

        //Condition for node being leaf and does not have the element already inside of it
        if(currentNode.isLeaf())
        {


            size++;
            if(currentNode.has1Key())
            {
                currentNode.setLargeKey(element);
                return;
            }

            if(currentNode == root)
            {
                currentNode.setTempMidKey(element);
                splitRootNode();
                return;
            }

            currentNode.setTempMidKey(element);
            currentNode.promoteTempMidKey();
            currentNode.splitNode();



            System.out.println(currentNode.getParentNode().getLargeKey());

            while(currentNode.getParentNode().getTempMidKey() != null)
            {

                currentNode = currentNode.getParentNode();

                if(currentNode == root)
                {
                    currentNode.setTempMidKey(element);
                    splitRootNode();
                    return;
                }

                currentNode.promoteTempMidKey();
                currentNode.splitNode();
            }


            return;

        }

        /**
         * From here we recursively search through the tree to find leaf
         *
         */


        //search mid if there is a mid node
            if( currentNode.getMidChild() != null && currentNode.getSmallKey() < element && element < currentNode.getLargeKey())
            {
                insertI(element,currentNode.getMidChild());
            }
            //search left
            else if (currentNode.getSmallKey() >  element)
            {
                insertI(element,currentNode.getSmallChild());
            }
            //search right
            else
            {
                insertI(element,currentNode.getLargeChild());
            }

    }


    public String search(Integer val)
    {
       return searchI(val, root);
    }

    private String searchI (int val, Node currentNode)
    {


        //System.out.println(currentNode.getSmallKey());

        boolean isFoundInNode = currentNode.getSmallKey() == val || (currentNode.getLargeKey() != null && currentNode.getLargeKey() == val);

        if(isFoundInNode)
        {

            if (currentNode.getLargeKey() != null)
            {

                return currentNode.getSmallKey() + " " + currentNode.getLargeKey();
            }

            String output = currentNode.getSmallKey().toString();
            return output;

        }

        if(currentNode.isLeaf() && !isFoundInNode)
        {

            if (currentNode.getLargeKey() != null)
            {

                return currentNode.getSmallKey() + " " + currentNode.getLargeKey();
            }

            String output = currentNode.getSmallKey().toString();
            return output;
        }

        //search mid if there is a mid node
        if( currentNode.getMidChild() != null && currentNode.getSmallKey() < val && val < currentNode.getLargeKey())
        {
            return searchI(val,currentNode.getMidChild());
        }
        //search left
        else if (currentNode.getSmallKey() >  val)
        {
           return searchI(val,currentNode.getSmallChild());
        }
        //search right
        else
        {
            return searchI(val,currentNode.getLargeChild());
        }


    }


   private void splitRootNode()
   {






           Node smallChild = new Node(root.getSmallKey());
           Node largeChild = new Node(root.getLargeKey());


           smallChild.setParentNode(root);
           largeChild.setParentNode(root);

            root = new Node(root.getTempMidKey());

           root.setSmallChild(smallChild);
           root.setLargeChild(largeChild);



           return;

   }


}