package fr.esiea;

public class Item  extends Buyable implements Updatable{

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality, int quantity, double price) {
        super(quantity, price);
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality+ ", "+super.toString();
    }

    @Override
    public void update() {
        if (this.quality > 0){ this.quality --; }
        this.sellIn --;
        if(quality > 0 && sellIn <0){ quality --; }
    }
}