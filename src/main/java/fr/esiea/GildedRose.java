package fr.esiea;


import java.util.ArrayList;

class GildedRose {
    ArrayList<Item> items;

    public GildedRose(ArrayList<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item i: items) {
            i.update();
        }
    }
}
