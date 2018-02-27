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
    @Override
    public void update() {
        this.increaseQuality();
        if(this.getSellIn() < 11){ this.increaseQualitySafely(); }
        if(this.getSellIn() < 6){ this.increaseQualitySafely(); }
        decreseSellIn();
        if(sellInDateIsOver()){ this.setQuality(0);}
    }
}