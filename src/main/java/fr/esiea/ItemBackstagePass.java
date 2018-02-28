package fr.esiea;


public class ItemBackstagePass extends Item {

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************

    /**
     * Constructor of BackstagePass with arguments
     * @param name
     * @param sellIn
     * @param quality
     * @param qte
     * @param price
     */
    public ItemBackstagePass(String name, int sellIn, int quality, int qte, double price) {
        super(name, sellIn, quality, qte, price);
    }

    /**
     * Constructor of BackstagePass without arguments, all is set by default.
     */
    public ItemBackstagePass() {
        super("Backstage passes to a TAFKAL80ETC concert",10, 10, 10, 40.99);
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************

    /**
     * Update method that override the mother one with a specific behavior
     */
    @Override
    public void update() {
        this.increaseQuality();
        if(this.getSellIn() < 11){ this.increaseQualitySafely(); }
        if(this.getSellIn() < 6){ this.increaseQualitySafely(); }
        decreseSellIn();
        if(sellInDateIsOver()){ this.setQuality(0);}
    }
}
