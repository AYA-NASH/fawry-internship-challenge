package org.example.tests;

import org.example.model.Cart;
import org.example.checkout.CheckoutService;
import org.example.model.Customer;
import org.example.model.Product;

import java.time.LocalDate;
import java.util.List;

public class TestCase3 implements TestCase{
    @Override
    public void run() {
        System.out.println("Test3: Out of Stock Product");
        List<Product> products = List.of(
                new Product("Biscuits", 150, 2, LocalDate.of(2025, 7, 10), true, 0.5)
        );

        Cart cart = new Cart();
        Customer customer = new Customer("customer", 1000);

        try{
            cart.add(products.get(0), 3);
            new CheckoutService(customer, cart);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n_____________________________________\n");
    }
}
