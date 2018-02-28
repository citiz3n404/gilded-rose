package fr.esiea;


public class ItemBrie extends Item {

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************
    /**
     * Constructor of Brie with arguments
     * @param name
     * @param sellIn
     * @param quality
     * @param qte
     * @param price
     */
    public ItemBrie(String name, int sellIn, int quality, int qte, double price) {
        super(name, sellIn, quality, qte, price);
    }

    /**
     * Constructor of Brie without arguments, all is set by default.
     */
    public ItemBrie() {
        super("Aged Brie",10, 10, 10, 9.99);
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************

    /**
     * Update method that override the mother one with a specific behavior
     */
    @Override
    public void update() {
        increaseQualitySafely();
        if(sellInDateIsOver()){
            this.increaseQualitySafely();
        }
        decreseSellIn();
    }
}
