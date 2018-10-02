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


        t = new TwoThreeTree();


    }




}