package fr.esiea;

public class Item  extends Buyable implements Updatable{

    private     String  name;
    private     int     sellIn;
    private     int     quality;

    public static final int MAX_QUALITY = 50;

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************
    public Item(String name, int sellIn, int quality, int quantity, double price) {
        super(quantity, price);
        this.name       = name;
        this.sellIn     = sellIn;
        this.quality    = quality;
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
        decreaseQualitySafely();
        deacreseSellIn();
        if(sellInDateIsOver()){
            decreaseQualitySafely();
        }
    }

    private boolean qualityCanBeDecreased(){
        return quality > 0;
    }

    private boolean qualityCanBeIncreased(){
        return this.quality +1 <= MAX_QUALITY;
    }

    public void decreaseQuality(){
        this.quality --;
    }

    public void decreaseQualitySafely(){
        if (qualityCanBeDecreased()){
            this.quality --;
        }
    }

    public void increaseQuality(){
        this.quality ++;
    }

    public void increaseQualitySafely(){
        if (qualityCanBeIncreased()){
            this.quality ++;
        }
    }

    public boolean sellInDateIsOver(){
        return sellIn<0;
    }

    public void deacreseSellIn(){
        sellIn --;
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
