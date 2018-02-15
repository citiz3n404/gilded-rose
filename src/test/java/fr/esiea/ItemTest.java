package fr.esiea;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void test_tostring(){
        Item item = new NormalItem("nameOfTest", 10, 30);
        assertEquals("nameOfTest, 10, 30", item.toString());
    }
}
