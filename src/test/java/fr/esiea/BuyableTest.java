package fr.esiea;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class BuyableTest {

    private GildedRose gr;

    @Before
    public void setUp() throws Exception {
        HashMap<String, Item> items = new HashMap<>();
        items.put("PotDeFleur", new Item("PotDeFleur", 10, 10, 5, 5));
        items.put("Aged Brie", new ItemBrie());
        items.put("Sulfuras, Hand of Ragnaros", new ItemSulfuras());
        items.put("Backstage passes to a TAFKAL80ETC concert", new ItemBackstagePasses());
        items.put("Conjured", new Item("Conjured", 20, 10, 5,5));
        gr = new GildedRose(items);
    }

    @Test
    public void lowerQuantityTest(){
        gr.items.get("PotDeFleur").lowerQuantity();
        assertEquals(gr.items.get("PotDeFleur").getQuantity(), 4);
    }

    @Test
    public void lowerQuantityByTest(){
        gr.items.get("PotDeFleur").lowerQuantityBy(5);
        assertEquals(gr.items.get("PotDeFleur").getQuantity(), 0);
    }

    @Test
    public void quantityCanBeLoweredTest(){
        assertEquals(gr.items.get("PotDeFleur").quantityCanBeLowered(), true);
    }

    @Test
    public void increaseQuantityTest(){
        gr.items.get("PotDeFleur").increaseQuantity();
        assertEquals(gr.items.get("PotDeFleur").getQuantity(), 6);
    }

    @Test
    public void increaseQuantityByTest(){
        gr.items.get("PotDeFleur").increaseQuantityBy(10);
        assertEquals(gr.items.get("PotDeFleur").getQuantity(), 15);
    }

    @Test
    public void setQuantityTest(){
        gr.items.get("PotDeFleur").setQuantity(15);
        assertEquals(gr.items.get("PotDeFleur").getQuantity(), 15);
    }

    @Test
    public void getPriceTest(){
        assertEquals(gr.items.get("PotDeFleur").getPrice(), 5.0, 0.001);
    }

    @Test
    public void setPriceTest(){
        gr.items.get("PotDeFleur").setPrice(14.152);
        assertEquals(gr.items.get("PotDeFleur").getPrice(), 14.152, 0.001);
    }
}
