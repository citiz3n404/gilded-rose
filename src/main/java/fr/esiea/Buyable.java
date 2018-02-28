package fr.esiea;


public abstract class Buyable {

    private     int     quantity;
    private     double  price;

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************

    /**
     * Constructor Buyable
     * @param quantity
     * @param price
     */
    public Buyable(int quantity, double price){
        this.quantity   = quantity;
        this.price      = price;
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************

    /**
     * Return a string formed for Json output
     * @return String : quantity, price,
     */
    @Override
    public String toString(){
        return this.quantity+", "+this.price+",";
    }

    /**
     * Lower quantity by the value given in param
     * @param i : The value to lower the quantity
     */
    public void lowerQuantityBy(int i){
        if (quantityCanBeLoweredBy(i)) {
            this.quantity -= i;
        }
    }

    /**
     * Lower the quantity by one
     */
    public void lowerQuantity(){
        this.quantity --;
    }

    /**
     * Say if the quantity can be lowered
     * @return boolean : true if quantity -1 > 0
     */
    public boolean quantityCanBeLowered(){
        return quantity-1 >=0;
    }

    /**
     * Increase the value of Quantity by one
     */
    public void increaseQuantity(){
        this.quantity ++;
    }

    /**
     * Check if quantity can be lowered by the quantity given in param
     * @param i int : the value supposed to be decreased
     * @return boolean : true if quantity - i still above or equal 0
     */
    public boolean quantityCanBeLoweredBy(int i){
        return quantity -i >= 0;
    }

    /**
     * Increase quantity by the given param
     * @param i int : quantity given to increase the quantity
     */
    public void increaseQuantityBy(int i){
        this.quantity += i;
    }

    //**************************************************************************
    //   SETTERS/GETTERS
    //**************************************************************************

    /**
     * Returns the quantity of the buyable thing
     * @return int : quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity by the parameter given
     * @param quantity int : new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the price of the buyable item
     * @return double : price of the buyable item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price by the given value in params
     * @param price double : new price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
