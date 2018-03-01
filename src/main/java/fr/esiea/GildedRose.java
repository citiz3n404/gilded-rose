package fr.esiea;

import java.util.HashMap;

class GildedRose implements Runnable{
    HashMap<String, Item> items;

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************

    /**
     * Constructor GildedRose
     * @param items : HashMap<String, Item>
     */
    public GildedRose(HashMap<String, Item> items) {
        this.items = items;
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************

    /**
     * Call the update method in each item in the HashMap
     */
    public void updateQuality() {
        for (Item i: items.values()) {
            i.update();
        }
    }

    /**
     * Method that call updateQuality(), basically to be run by a different thread
     */
    @Override
    public void run() {
        updateQuality();
    }
}