package PizzaShop;

import java.util.List;

public class OrderItem {
    private int quantity;
    private String type, size;
    private double price;


    // A no-argument (default) constructor that initializes the four instance variables to appropriate values. //
    public OrderItem( )
    {
        quantity = 1;
        type = "Meat Lovers";
        size = "Large";
        price = 19.00;
    }

    // A four-argument constructor that initializes the four instance variables to the parameter values. //
    public OrderItem(int quantity, String type, String size, double price){
        this.quantity = quantity;
        this.type = type;
        this.size = size;
        this.price = price;
    }


    // set and get methods for each of the four instance variables.
    public int getQuantity()
    {
        //getting the quantity variable instance
        return quantity;
    }

    public String getType(int pizzaInput)
    {
        //getting the type variable instance
        return type;
    }

    public String getSize()
    {
        //getting the size variable instance
        return size;
    }

    public double getPrice()
    {
        //getting the price variable instance
        return price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setSize(String size){
        this.size = size;
    }

    public void setPrice(double price){
        this.price = price;
    }


    // A toString method to generate nicely formatted output. //
    public String toString() {
        return String.format("%-15s\t%-12s\t%-7s\t$%.2f", type, size, quantity, price);
    }
}

