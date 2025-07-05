package org.example.tests;


import org.example.checkout.CheckoutService;
import org.example.model.Cart;
import org.example.model.Customer;

public class TestCase7 implements TestCase {
    @Override
    public void run() {
        System.out.println("Test7: Empty Cart Test");

        Cart cart = new Cart();
        Customer customer = new Customer("TestUser", 1000);

        try {
            new CheckoutService(customer, cart);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected: "Error: Cart is empty..."
        }

        System.out.println("\n_____________________________________\n");
    }
}

