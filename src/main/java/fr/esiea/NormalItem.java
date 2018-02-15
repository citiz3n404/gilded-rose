package fr.esiea;


public class NormalItem extends Item {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        if (this.quality > 0){
            this.quality --;
        }
        this.sellIn --;

        if(quality > 0 && sellIn <0){
            quality --;
        }
    }
}
