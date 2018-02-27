package fr.esiea;


public class ItemSulfuras extends Item {

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************
    public ItemSulfuras(String name, int sellIn, int quality, int qte, double price) {
        super(name, sellIn, quality, qte, price);
    }

    public ItemSulfuras() {
        super("Sulfuras, Hand of Ragnaros", 20, 50, 1, 1000000.99);
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************
    public void update() {

    }
}