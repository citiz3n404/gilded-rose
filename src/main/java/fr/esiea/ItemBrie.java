package fr.esiea;


public class ItemBrie extends Item {

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************
    public ItemBrie(String name, int sellIn, int quality, int qte, double price) {
        super(name, sellIn, quality, qte, price);
    }

    public ItemBrie() {
        super("Aged Brie",10, 10, 10, 9.99);
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************
    @Override
    public void update() {
        increaseQualitySafely();
        if(sellInDateIsOver()){
            this.increaseQualitySafely();
        }
        deacreseSellIn();
    }
}