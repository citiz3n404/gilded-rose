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
        items.put("Aged Brie", new Brie());
        items.put("Sulfuras, Hand of Ragnaros", new Sulfuras());
        items.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePasses());
        items.put("Conjured", new Item("Conjured", 20, 10, 5,5));
        gr = new GildedRose(items);
    }

    @Test
    public void object_degrades_one_per_day(){
        Item i = new Item("PotDeFleur", 10, 10, 5,5);
        i.update();
        assertEquals(9, i.quality);
    }

    @Test
    public void when_date_has_passed_degrades_twice_faster(){
        Item i = new Item("PotDeFleur", 0, 10, 5,5);
        i.update();
        assertEquals(8, i.quality);
    }

    @Test
    public void agedbrie_increases_in_quality_near_sellIn_value(){
        // Under 6 of SellIn Value, it gets +1 of quality each update
        Item i = new Brie("Aged Brie", 2, 40, 5,5);
        i.update();
        assertEquals(41, i.quality);
    }

    @Test
    public void quality_of_an_item_is_never_above_fifty(){
        //Beware if an object is initialized with more than fifty, it is possible.
        gr.items.get("Aged Brie").quality = 45;
        for(int i = 0; i<10; i++){
            gr.updateQuality();
        }
        assertEquals(50,gr.items.get("Aged Brie").quality);
    }

    @Test
    public void sulfuras_never_has_to_be_sold_or_decrease_quality(){
        Item i = new Sulfuras("Sulfuras, Hand of Ragnaros", 10, 20, 5,5);
        for(int j = 0; j<3; j++){
            i.update();
        }
        assertEquals(20, i.quality);
        assertEquals(10, i.sellIn);
    }

    @Test
    public void backstagepasses_increases_by_two_under_ten_days(){
        Item i = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 9, 10, 5,5);
        i.update();
        assertEquals(12, i.quality);
    }

    @Test
    public void backstagepasses_increases_by_three_under_five_days(){
        Item i = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 4, 10, 5,5);
        i.update();
        assertEquals(13, i.quality);
    }

    @Test
    public void backtagepasses_decrease_to_zero_after_the_concert(){
        Item i = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 0, 10,5,5);
        i.update();
        assertEquals(0, i.quality);
    }

    @Test
    public void agedbrie_gets_plus_two_of_quality_if_under_fifty_and_sellin_under_zero(){
        Item i = new Brie("Aged Brie", -1, 46, 5,5);
        i.update();
        assertEquals(48, i.quality);
    }

    @Test
    public void runTest(){
        gr.run();
        assertEquals(gr.items.get("PotDeFleur").sellIn, 9);
    }
}
