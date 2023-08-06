package machine.components;

import products.Product;

import java.util.ArrayList;

public class Drawer {

    private ArrayList<Product> items;
    private Code code;
    private double price;

    public Drawer(Code code, double price) {
        this.code = code;
        items = new ArrayList<>();
        this.price = price;
    }

    public Code getCode() {
        return code;
    }

    public int itemCount(){
        return this.items.size();
    }

    public void addItem(Product product){
        this.items.add(product);
    }

    public Product vendProduct(){
        return this.items.remove(0);
    }

    public double getPrice(){
        return this.price;
    }
}
