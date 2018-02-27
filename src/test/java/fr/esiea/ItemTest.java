package fr.esiea;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ItemTest {

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
    public void object_degrades_one_per_day(){
        Item i = new Item("PotDeFleur", 10, 10, 5,5);
        i.update();
        assertEquals(9, i.getQuality());
    }

    @Test
    public void when_date_has_passed_degrades_twice_faster(){
        Item i = new Item("PotDeFleur", 0, 10, 5,5);
        i.update();
        assertEquals(8, i.getQuality());
    }

    @Test
    public void agedbrie_increases_in_quality_near_sellIn_value(){
        // Under 6 of SellIn Value, it gets +1 of quality each update
        Item i = new ItemBrie("Aged Brie", 2, 40, 5,5);
        i.update();
        assertEquals(41, i.getQuality());
    }

    @Test
    public void quality_of_an_item_is_never_above_fifty(){
        //Beware if an object is initialized with more than fifty, it is possible.
        gr.items.get("Aged Brie").setQuality(45);;
        for(int i = 0; i<10; i++){
            gr.updateQuality();
        }
        assertEquals(50,gr.items.get("Aged Brie").getQuality());
    }

    @Test
    public void sulfuras_never_has_to_be_sold_or_decrease_quality(){
        Item i = new ItemSulfuras("Sulfuras, Hand of Ragnaros", 10, 20, 5,5);
        for(int j = 0; j<3; j++){
            i.update();
        }
        assertEquals(20, i.getQuality());
        assertEquals(10, i.getSellIn());
    }

    @Test
    public void backstagepasses_increases_by_two_under_ten_days(){
        Item i = new ItemBackstagePass("Backstage passes to a TAFKAL80ETC concert", 9, 10, 5,5);
        i.update();
        assertEquals(12, i.getQuality());
    }

    @Test
    public void backstagepasses_increases_by_three_under_five_days(){
        Item i = new ItemBackstagePass("Backstage passes to a TAFKAL80ETC concert", 4, 10, 5,5);
        i.update();
        assertEquals(13, i.getQuality());
    }

    @Test
    public void backtagepasses_decrease_to_zero_after_the_concert(){
        Item i = new ItemBackstagePass("Backstage passes to a TAFKAL80ETC concert", 0, 10,5,5);
        i.update();
        assertEquals(0, i.getQuality());
    }

    @Test
    public void agedbrie_gets_plus_two_of_quality_if_under_fifty_and_sellin_under_zero(){
        Item i = new ItemBrie("Aged ItemBrie", -1, 46, 5,5);
        i.update();
        assertEquals(48, i.getQuality());
    }

    @Test
    public void test_tostring(){
        Item item = new Item("nameOfTest", 10, 30, 5,5);
        assertEquals("nameOfTest, 10, 30, 5, 5.0,", item.toString());
    }

    @Test
    public void itemGetter(){
        Item i = new ItemBackstagePass("Backstage passes to a TAFKAL80ETC concert", 0, 10,5,5);
        assertEquals(i.getName(), "Backstage passes to a TAFKAL80ETC concert");
    }

    @Test
    public void itemSetter(){
        Item i = new ItemBackstagePass("Backstage passes to a TAFKAL80ETC concert", 0, 10,5,5);
        i.setName("Toto");
        assertEquals(i.getName(), "Toto");
    }

    @Test
    public void sellInSetter(){
        Item i = new ItemBackstagePass("Backstage passes to a TAFKAL80ETC concert", 0, 10,5,5);
        i.setSellIn(12);
        assertEquals(i.getSellIn(), 12);
    }

    @Test
    public void decreaseQualityTest(){
        Item i = new Item("Nimp", 0, 10,5,5);
        i.decreaseQuality();
        assertEquals(i.getQuality(), 9);
    }
}
