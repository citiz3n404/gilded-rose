package fr.esiea;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void test_tostring(){
        Item item = new Item("nameOfTest", 10, 30, 5,5);
        assertEquals("nameOfTest, 10, 30, 5, 5.0,", item.toString());
    }
}
