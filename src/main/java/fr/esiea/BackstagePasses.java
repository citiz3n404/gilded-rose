package fr.esiea;


public class BackstagePasses extends Item {

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public BackstagePasses() {
        super("Backstage passes to a TAFKAL80ETC concert",10, 10);
    }

    public void update() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }

        if(this.sellIn < 11){
            this.quality ++;
        }
        if(this.sellIn < 6){
            this.quality ++;
        }

        this.sellIn --;

        if(this.sellIn <0){
            quality = 0;
        }

    }
}
