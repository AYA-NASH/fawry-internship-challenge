package org.example.shipping;

import org.example.model.Product;

public class ShippableProduct implements Shippable{
    private Product product;
    private int quantity;

    public ShippableProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return this.quantity+"x "+ this.product.getName();
    }

    @Override
    public double getWeight() {
        return this.product.getWeight() * this.quantity;
    }
}
