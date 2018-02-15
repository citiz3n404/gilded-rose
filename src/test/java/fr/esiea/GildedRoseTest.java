package fr.esiea;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GildedRoseTest{
    private GildedRose gr;

    @Before
    public void setUp() throws Exception {
        ArrayList<Item> items = new ArrayList();
        items.add(new NormalItem("PotDeFleur", 10, 10));
        items.add(new Brie());
        items.add(new Sulfuras());
        items.add(new BackstagePasses());
        items.add(new NormalItem("Conjured", 20, 10));
        gr = new GildedRose(items);
    }

    @Test
    public void object_degrades_one_per_day(){
        Item i = new NormalItem("PotDeFleur", 10, 10);
        i.update();
        assertEquals(9, i.quality);
    }

    @Test
    public void when_date_has_passed_degrades_twice_faster(){
        Item i = new NormalItem("PotDeFleur", 0, 10);
        i.update();
        assertEquals(8, i.quality);
    }

    @Test
    public void agedbrie_increases_in_quality_near_sellIn_value(){
        // Under 6 of SellIn Value, it gets +1 of quality each update
        Item i = new Brie("Aged Brie", 2, 40);
        i.update();
        assertEquals(41, i.quality);
    }

    @Test
    public void quality_of_an_item_is_never_above_fifty(){
        //Beware if an object is initialized with more than fifty, it is possible.
        gr.items.get(1).quality = 45;
        for(int i = 0; i<10; i++){
            gr.updateQuality();
        }
        assertEquals(50,gr.items.get(1).quality);
    }

    @Test
    public void sulfuras_never_has_to_be_sold_or_decrease_quality(){
        Item i = new Sulfuras("PotDeFleur", 10, 20);
        for(int j = 0; j<3; j++){
            i.update();
        }
        assertEquals(20, i.quality);
        assertEquals(10, i.sellIn);
    }

    @Test
    public void backstagepasses_increases_by_two_under_ten_days(){
        Item i = new BackstagePasses("PotDeFleur", 9, 10);
        i.update();
        assertEquals(12, i.quality);
    }

    @Test
    public void backstagepasses_increases_by_three_under_five_days(){
        Item i = new BackstagePasses("PotDeFleur", 4, 10);
        i.update();
        assertEquals(13, i.quality);
    }

    @Test
    public void backtagepasses_decrease_to_zero_after_the_concert(){
        Item i = new BackstagePasses("PotDeFleur", 0, 10);
        i.update();
        assertEquals(0, i.quality);
    }

    @Test
    public void agedbrie_gets_plus_two_of_quality_if_under_fifty_and_sellin_under_zero(){
        Item i = new Brie("Aged Brie", -1, 46);
        i.update();
        assertEquals(48, i.quality);
    }
}
