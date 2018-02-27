package fr.esiea;


public class ItemBackstagePass extends Item {

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************
    public ItemBackstagePass(String name, int sellIn, int quality, int qte, double price) {
        super(name, sellIn, quality, qte, price);
    }

    public ItemBackstagePass() {
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