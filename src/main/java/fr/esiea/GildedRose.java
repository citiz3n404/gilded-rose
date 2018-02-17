package fr.esiea;

import java.util.HashMap;

class GildedRose implements Runnable{
    HashMap<String, Item> items;

    public GildedRose(HashMap<String, Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item i: items.values()) {
            i.update();
        }
    }

    @Override
    public void run() {
        updateQuality();
    }
}
