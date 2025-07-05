package org.example.tests;

import org.example.model.Cart;
import org.example.checkout.CheckoutService;
import org.example.model.Customer;
import org.example.model.Product;

import java.time.LocalDate;
import java.util.List;

public class TestCase2 implements TestCase{
    @Override
    public void run() {
        System.out.println("Test2: Expired Product Test");
        List<Product> products = List.of(
                new Product("Milk", 30, 3, LocalDate.of(2024, 12, 1), true, 1.0)
        );

        Cart cart = new Cart();
        Customer customer = new Customer("customer", 500);

        try{
            cart.add(products.get(0), 1);
            new CheckoutService(customer, cart);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n_____________________________________\n");
    }
}
