

public class TwoThreeTree
{

    private Node root;
    private int size;


    public TwoThreeTree ()
    {



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

            currentNode.setTempMidKey(element);
            currentNode.promoteTempMidKey();
            currentNode.splitNode();

            while(currentNode.getParentNode().has3Keys())
            {
                currentNode = currentNode.getParentNode();
                if(currentNode == root)
                {
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
            if( currentNode.getSmallKey() < element && element < currentNode.getLargeKey() && currentNode.getMidChild() != null)
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
       if(size == 3) {
           root = new Node(root.getTempMidKey());


           Node leftNode = new Node(root.getSmallKey());
           Node rightNode = new Node(root.getLargeKey());

           leftNode.setParentNode(root);
           rightNode.setParentNode(root);

           root.setSmallChild(leftNode);
           root.setLargeChild(rightNode);
           return;
       }
   }


}