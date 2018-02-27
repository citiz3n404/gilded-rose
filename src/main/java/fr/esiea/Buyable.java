package fr.esiea;


public abstract class Buyable {

    private     int     quantity;
    private     double  price;

    //**************************************************************************
    //   CONSTRUCTOR
    //**************************************************************************

    public Buyable(int quantity, double price){
        this.quantity = quantity;
        this.price = price;
    }


    //**************************************************************************
    //   METHODS
    //**************************************************************************
    @Override
    public String toString(){
        return this.quantity+", "+this.price+",";
    }

    public void lowerQuantityBy(int i){
        if (quantityCanBeLoweredBy(i)) {
            this.quantity -= i;
        }
    }

    public void lowerQuantity(){
        this.quantity --;
    }

    public boolean quantityCanBeLowered(){
        return quantity-1 >=0;
    }

    public void increaseQuantity(int i){
        this.quantity += i;
    }

    public boolean quantityCanBeLoweredBy(int i){
        return quantity -i >= 0;
    }

    public void addToQuantity(int i){
        this.quantity += i;
    }

    //**************************************************************************
    //   SETTERS/GETTERS
    //**************************************************************************
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
