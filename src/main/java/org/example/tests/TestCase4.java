package org.example.tests;

import org.example.model.Cart;
import org.example.checkout.CheckoutService;
import org.example.model.Customer;
import org.example.model.Product;

import java.time.LocalDate;
import java.util.List;

public class TestCase4 implements TestCase{
    @Override
    public void run() {
        System.out.println("Test4: Insufficient Balance Test");
        List<Product> products = List.of(
                new Product("TV", 3000, 1, null, true, 5.5),
                new Product("Cheese", 100, 1, LocalDate.of(2025, 7, 10), true, 0.2)
        );

        Cart cart = new Cart();
        Customer customer = new Customer("customer", 500);
        try{
            cart.add(products.get(0), 1);
            cart.add(products.get(1), 1);
            new CheckoutService(customer, cart);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n_____________________________________\n");
    }
}
