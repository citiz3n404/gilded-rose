package fr.esiea;

public class Item implements Updatable{

    public String name;

    public int sellIn;

    public int quality;

    public int quantity;

    public double price;

    public Item(String name, int sellIn, int quality, int quantity, double price) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality+ ", "+ this.quantity+", "+this.price+",";
    }

    @Override
    public void update() {
        if (this.quality > 0){ this.quality --; }
        this.sellIn --;
        if(quality > 0 && sellIn <0){ quality --; }
    }
}
