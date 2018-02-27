package fr.esiea;

public class Item  extends Buyable implements Updatable{

    public String name;

    public  int sellIn;

    public int quality;

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************
    public Item(String name, int sellIn, int quality, int quantity, double price) {
        super(quantity, price);
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************

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


    //**************************************************************************
    //   SETTERS/GETTERS
    //**************************************************************************

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}