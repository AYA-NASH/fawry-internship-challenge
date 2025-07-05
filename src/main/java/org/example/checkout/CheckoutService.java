package org.example.checkout;

import org.example.model.Cart;
import org.example.model.CartItem;
import org.example.model.Customer;
import org.example.model.Product;
import org.example.shipping.Shippable;
import org.example.shipping.ShippableProduct;
import org.example.shipping.ShippingService;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private Customer customer;
    private Cart cart;
    private final int SHIPPING_FEES = 30;
    private double subTotal = 0;

    public CheckoutService(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
        getTotalPrice();
        if(customer.getBalance() < (subTotal + SHIPPING_FEES)){
            throw new IllegalArgumentException("Error: Insufficient Balance");
        }
        doCheckout();
    }

    private void getTotalPrice(){
        List<CartItem> items = cart.getCartItems();
        for (CartItem item : items){
            subTotal += item.getItemPrice();
        }
    }

    private void doCheckout() {
        if (cart.getCartItems().isEmpty()) {
            throw new IllegalArgumentException("Error: Cart is empty. Cannot proceed to checkout.");
        }

        List<CartItem> items = cart.getCartItems();
        double subTotal = 0;

        getShippingService(items);

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            int qt = item.getQuantity();
            String name = item.getProduct().getName();
            double price = item.getItemPrice();
            subTotal += price;
            System.out.println(qt + "x " + name + "    " + price);
        }

        System.out.println("-------------");
        System.out.println("Subtotal: " + subTotal);
        System.out.println("Shipping: " + SHIPPING_FEES);
        System.out.println("Amount: " + (subTotal + SHIPPING_FEES));

        customer.reduceBalance(subTotal + SHIPPING_FEES);
        System.out.println("Customer balance after payment: " + customer.getBalance());
    }

    private void getShippingService(List<CartItem> items){
        List<Shippable> shippableItems = new ArrayList<>();

        for(CartItem item: items){
            Product product = item.getProduct();
            if(product.isShippable()){
                shippableItems.add(new ShippableProduct(product, item.getQuantity()));
            }
        }

        ShippingService.ship(shippableItems);
    }
}
