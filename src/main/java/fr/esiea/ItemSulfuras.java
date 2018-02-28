package fr.esiea;


public class ItemSulfuras extends Item {

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************

    /**
     * Constructor of Sulfuras with arguments
     * @param name
     * @param sellIn
     * @param quality
     * @param qte
     * @param price
     */
    public ItemSulfuras(String name, int sellIn, int quality, int qte, double price) {
        super(name, sellIn, quality, qte, price);
    }

    /**
     * Constructor of Sulfuras without arguments
     */
    public ItemSulfuras() {
        super("Sulfuras, Hand of Ragnaros", 20, 50, 1, 1000000.99);
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************

    /**
     * Update method that override the mother one with a specific behavior,
     * notice that as Sulfuras is legendary item, nothing affect it.
     */
    @Override
    public void update() {

    }
}
