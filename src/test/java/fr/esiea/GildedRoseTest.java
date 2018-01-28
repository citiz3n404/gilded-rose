package fr.esiea;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class GildedRoseTest{

    @Test
    public void objet_de_qualite(){
        Item[] items = new Item[3];
        items[0] = new Item("PotDeFleur", 10, 10);
        items[1] = new Item("Conjured", 4, 3);
        items[2] = new Item("Aged Brie", 50, 40);

        GildedRose gr = new GildedRose(items);
        gr.updateQuality();
        //assertTrue("True", true);
        assertEquals(9, gr.items[0].quality);
    }
}
