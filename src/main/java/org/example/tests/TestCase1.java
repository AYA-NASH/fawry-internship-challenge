package org.example.tests;

import org.example.model.Cart;
import org.example.checkout.CheckoutService;
import org.example.model.Customer;
import org.example.model.Product;

import java.time.LocalDate;
import java.util.List;

public class TestCase1 implements TestCase{
    @Override
    public void run() {
        System.out.println("Test1: Checkout Done Successfully");
        List<Product> products = List.of(
                new Product("Cheese", 100, 5, LocalDate.of(2025, 7, 10), true, 0.2),
                new Product("TV", 3000, 2, null, true, 5.5),
                new Product("Scratch Card", 50, 10, null, false, 0)
        );

        Cart cart = new Cart();
        Customer customer = new Customer("customer", 4000);

        try {
            cart.add(products.get(0), 2);
            cart.add(products.get(1), 1);
            cart.add(products.get(2), 1);
            new CheckoutService(customer, cart);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n_____________________________________\n");
    }
}
