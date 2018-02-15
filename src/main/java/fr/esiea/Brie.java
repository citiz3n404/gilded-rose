package fr.esiea;


public class Brie extends Item {

    public Brie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public Brie() {
        super("Aged Brie",10, 10);
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
