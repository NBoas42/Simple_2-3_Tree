import org.junit.Test;
import static org.junit.Assert.*;

public class TwoThreeTreeGivenTests
{

    @Test
    public void singleNodeTree()
    {
        TwoThreeTree t = new TwoThreeTree();
        int val = 9;
        t.insert(val);
        String expected = "9";

        assertEquals(expected, t.search(val));
        val = 8;
        assertEquals(expected, t.search(val));
        val = 10;
        assertEquals(expected, t.search(val));

        val = 15;
        t.insert(val);
        expected = "9 15";
        val = 9;
        assertEquals(expected, t.search(val));
        val = 8;
        assertEquals(expected, t.search(val));
        val = 10;
        assertEquals(expected, t.search(val));
        val = 15;
        assertEquals(expected, t.search(val));
        val = 18;
        assertEquals(expected, t.search(val));

        t = new TwoThreeTree();
        val = 15;
        t.insert(val);
        val = 9;
        t.insert(val);
        val = 9;
        assertEquals(expected, t.search(val));
        val = 8;
        assertEquals(expected, t.search(val));
        val = 10;
        assertEquals(expected, t.search(val));
        val = 15;
        assertEquals(expected, t.search(val));
        val = 18;
        assertEquals(expected, t.search(val));

    }

    @Test
    public void oneSplitLeft()
    {
        TwoThreeTree t = new TwoThreeTree();
        t.insert(9);
        t.insert(15);
        t.insert(1);

        String expected = "9";
        assertEquals(expected, t.search(9));
        expected = "15";
        assertEquals(expected, t.search(15));
        assertEquals(expected, t.search(17));
        assertEquals(expected, t.search(11));

        expected = "1";
        assertEquals(expected, t.search(1));
        assertEquals(expected, t.search(0));
        assertEquals(expected, t.search(3));
    }

    @Test
    public void oneSplitRight()
    {
        TwoThreeTree t = new TwoThreeTree();
        t.insert(1);
        t.insert(9);
        t.insert(15);

        String expected = "9";
        assertEquals(expected, t.search(9));
        expected = "15";
        assertEquals(expected, t.search(15));
        assertEquals(expected, t.search(17));
        assertEquals(expected, t.search(11));

        expected = "1";
        assertEquals(expected, t.search(1));
        assertEquals(expected, t.search(0));
        assertEquals(expected, t.search(3));
    }

    @Test
    public void oneSplitMiddle()
    {
        TwoThreeTree t = new TwoThreeTree();
        t.insert(1);
        t.insert(15);
        t.insert(9);

        String expected = "9";
        assertEquals(expected, t.search(9));
        expected = "15";
        assertEquals(expected, t.search(15));
        assertEquals(expected, t.search(17));
        assertEquals(expected, t.search(11));

        expected = "1";
        assertEquals(expected, t.search(1));
        assertEquals(expected, t.search(0));
        assertEquals(expected, t.search(3));
    }


    @Test
    public void testDuplicates()
    {
        TwoThreeTree t = new TwoThreeTree();
        t.insert(1);
        t.insert(9);
        t.insert(15);
        t.insert(13);
        t.insert(20);
        t.insert(7);


        t.printTree();

    }




}