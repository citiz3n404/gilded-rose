package fr.esiea;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class GildedRoseTest{
    private GildedRose gr;

    @Before
    public void setUp() throws Exception {
        HashMap<String, Item> items = new HashMap<>();
        items.put("PotDeFleur", new Item("PotDeFleur", 10, 10, 5, 5));
        items.put("Aged Brie", new ItemBrie());
        items.put("Sulfuras, Hand of Ragnaros", new ItemSulfuras());
        items.put("Backstage passes to a TAFKAL80ETC concert", new ItemBackstagePass());
        items.put("Conjured", new Item("Conjured", 20, 10, 5,5));
        gr = new GildedRose(items);
    }

    @Test
    public void runTest(){
        gr.run();
        assertEquals(gr.items.get("PotDeFleur").getSellIn(), 9);
    }



}
