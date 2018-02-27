package fr.esiea;


public abstract class Buyable {

    public int quantity;

    public double price;

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