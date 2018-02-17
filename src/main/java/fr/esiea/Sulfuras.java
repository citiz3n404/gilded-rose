package fr.esiea;


public class Sulfuras extends Item {
    public Sulfuras(String name, int sellIn, int quality, int qte, double price) {
        super(name, sellIn, quality, qte, price);
    }

    public Sulfuras() {
        super("Sulfuras, Hand of Ragnaros", 20, 50, 1, 1000000.99);
    }

    public void update() {

    }
}
