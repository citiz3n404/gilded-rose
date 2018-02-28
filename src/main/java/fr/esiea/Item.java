package fr.esiea;

public class Item  extends Buyable implements Updatable{

    private     String  name;
    private     int     sellIn;
    private     int     quality;

    public static final int MAX_QUALITY = 50;

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************

    /**
     * Constructor Item
     * @param name
     * @param sellIn
     * @param quality
     * @param quantity
     * @param price
     */
    public Item(String name, int sellIn, int quality, int quantity, double price) {
        super(quantity, price);
        this.name       = name;
        this.sellIn     = sellIn;
        this.quality    = quality;
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************

    /**
     * Returns a string formed for Json output
     * @return String : name, sellIn, quality, quantity, price
     */
    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality+ ", "+super.toString();
    }

    /**
     * Updates the item, decrease by one the quality if !sellInDateIsOver, by 2 if it is.
     * Decrease also the sellIn day.
     */
    @Override
    public void update() {
        decreaseQualitySafely();
        decreseSellIn();
        if(sellInDateIsOver()){
            decreaseQualitySafely();
        }
    }

    /**
     * Check if it is possible the quality of an item (>0)
     * @return boolean : true if item can be decreased.
     */
    private boolean qualityCanBeDecreased(){
        return quality > 0;
    }

    /**
     * Check if qualityCanBeIncreased (< MAX_QUALITY)
     * @return boolean : true if quantity can be increased
     */
    private boolean qualityCanBeIncreased(){
        return this.quality +1 <= MAX_QUALITY;
    }

    /**
     * Decrease quality by one
     */
    public void decreaseQuality(){
        this.quality --;
    }

    /**
     * Safe method which decrease quality only if it is possible
     */
    public void decreaseQualitySafely(){
        if (qualityCanBeDecreased()){
            this.quality --;
        }
    }

    /**
     * Increase quality by one
     */
    public void increaseQuality(){
        this.quality ++;
    }

    /**
     * Safe method which increase quality only if it is possible
     */
    public void increaseQualitySafely(){
        if (qualityCanBeIncreased()){
            this.quality ++;
        }
    }

    /**
     * Check if the sellIn date of the item is over or not
     * @return boolean : true if date is over.
     */
    public boolean sellInDateIsOver(){
        return sellIn<0;
    }

    /**
     * Decrease sellIn by one
     */
    public void decreseSellIn(){
        sellIn --;
    }


    //**************************************************************************
    //   SETTERS/GETTERS
    //**************************************************************************

    /**
     * Returns the item's name
     * @return String : name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the item's name
     * @param name String : name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the item's sellIn date
     * @return int : sellIn date
     */
    public int getSellIn() {
        return sellIn;
    }

    /**
     * Set the item's sellIn
     * @param sellIn int : sellIn
     */
    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    /**
     * Returns the item's quality
     * @return int : quality
     */
    public int getQuality() {
        return quality;
    }

    /**
     * Set the item's quality
     * @param quality int
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }
}