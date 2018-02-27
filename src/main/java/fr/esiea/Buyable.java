package fr.esiea;


public abstract class Buyable {
    public int quantity;

    public double price;

    public Buyable(int quantity, double price){
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString(){
        return this.quantity+", "+this.price+",";
    }
}