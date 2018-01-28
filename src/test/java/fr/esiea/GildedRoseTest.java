package fr.esiea;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GildedRoseTest{
    private GildedRose gr;

    @Before
    public void setUp() throws Exception {
        Item[] items = new Item[5];
        items[0] = new Item("PotDeFleur", 10, 10);
        items[1] = new Item("Conjured", 4, 3);
        items[2] = new Item("Aged Brie", 10, 40);
        items[3] = new Item("Sulfuras, Hand of Ragnaros", 10, 20);
        items[4] = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        gr = new GildedRose(items);
    }

    @Test
    public void object_degrades_one_per_day(){
        gr.items[0].quality = 10;
        gr.updateQuality();
        assertEquals(9, gr.items[0].quality);
    }

    @Test
    public void when_date_has_passed_degrades_twice_faster(){
        gr.items[0].sellIn = 0;
        gr.items[0].quality = 10;
        gr.updateQuality();
        assertEquals(8, gr.items[0].quality);
    }

    @Test
    public void agedbrie_increases_in_quality_near_sellIn_value(){
        // Under 6 of SellIn Value, it gets +1 of quality each update
        gr.items[2].quality = 40;
        gr.items[2].sellIn = 2;
        gr.updateQuality();
        assertEquals(41, gr.items[2].quality);
    }

    @Test
    public void quality_of_an_item_is_never_above_fifty(){
        //Beware if an object is initialized with more than fifty, it is possible.
        gr.items[2].quality = 45;
        for(int i = 0; i<10; i++){
            gr.updateQuality();
        }
        assertEquals(50, gr.items[2].quality);
    }

    @Test
    public void sulfuras_never_has_to_be_sold_or_decrease_quality(){
        gr.items[3].quality = 20;
        gr.items[3].sellIn = 10;
        for(int i = 0; i<3; i++){
            gr.updateQuality();
        }
        assertEquals(20, gr.items[3].quality);
        assertEquals(10, gr.items[3].sellIn);
    }

    @Test
    public void backstagepasses_increases_by_two_under_ten_days(){
        gr.items[4].sellIn = 9;
        gr.items[4].quality = 10;
        gr.updateQuality();
        assertEquals(12, gr.items[4].quality);
    }

    @Test
    public void backstagepasses_increases_by_three_under_five_days(){
        gr.items[4].sellIn = 4;
        gr.items[4].quality = 10;
        gr.updateQuality();
        assertEquals(13, gr.items[4].quality);
    }

    @Test
    public void backtagepasses_decrease_to_zero_after_the_concert(){
        gr.items[4].sellIn = 0;
        gr.items[4].quality = 10;
        gr.updateQuality();
        assertEquals(0, gr.items[4].quality);
    }
}
