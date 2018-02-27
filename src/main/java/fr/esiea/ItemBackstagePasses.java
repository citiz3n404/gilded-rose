package fr.esiea;


public class ItemBackstagePasses extends Item {

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************
    public ItemBackstagePasses(String name, int sellIn, int quality, int qte, double price) {
        super(name, sellIn, quality, qte, price);
    }

    public ItemBackstagePasses() {
        super("Backstage passes to a TAFKAL80ETC concert",10, 10, 10, 40.99);
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************
    public void update() {
        if (this.quality < 50) { this.quality ++; }
        if(this.sellIn < 11){ this.quality ++; }
        if(this.sellIn < 6){ this.quality ++; }
        this.sellIn --;
        if(this.sellIn <0){ quality = 0; }
    }
}