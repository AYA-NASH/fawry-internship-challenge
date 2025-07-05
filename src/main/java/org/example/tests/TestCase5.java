package org.example.tests;

import org.example.model.Cart;
import org.example.checkout.CheckoutService;
import org.example.model.Customer;
import org.example.model.Product;

import java.util.List;

public class TestCase5 implements TestCase{
    @Override
    public void run() {
        System.out.println("Test5: No Products to ship");

        List<Product> products = List.of(
                new Product("E-Book", 150, 2, null, false, 0),
                new Product("Scratch Card", 50, 5, null, false, 0)
        );

        Cart cart = new Cart();
        Customer customer = new Customer("customer", 1000);

        try {
            cart.add(products.get(0), 1);
            cart.add(products.get(1), 2);
            new CheckoutService(customer, cart);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n_____________________________________\n");
    }
}
