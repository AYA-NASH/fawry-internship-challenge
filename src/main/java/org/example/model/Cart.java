package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void add(Product product, int quantity){

        if (product.getExpiryDate() != null && LocalDate.now().isAfter(product.getExpiryDate())) {

            throw new IllegalArgumentException("Error: "+ product.getName() + " is Expired");
        }

        if(quantity > product.getQuantity()){
            throw new IllegalArgumentException("Error: Not enough stock for " + product.getName() + "\n Existing is: "+ product.getQuantity() + "\n requested: " + quantity);
        }

        cartItems.add(new CartItem(quantity, product));
        product.reduceQuantity(quantity);
    }

}
