package fr.esiea;


public class Brie extends Item {

    public Brie(String name, int sellIn, int quality, int qte, double price) {
        super(name, sellIn, quality, qte, price);
    }

    public Brie() {
        super("Aged Brie",10, 10, 10, 9.99);
    }

    public void update() {
        if (this.quality < 50) {
            this.quality ++;
        }

        if(this.quality < 50 && this.sellIn <0){
            this.quality ++;
        }

        this.sellIn --;
    }
}
