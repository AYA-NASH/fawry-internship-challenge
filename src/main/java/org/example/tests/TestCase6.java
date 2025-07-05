package org.example.tests;

import org.example.model.Cart;
import org.example.checkout.CheckoutService;
import org.example.model.Customer;
import org.example.model.Product;

import java.time.LocalDate;
import java.util.List;

public class TestCase6 implements TestCase{

    @Override
    public void run() {
        System.out.println("Test6: Use Multiple Cases");

        List<Product> products = List.of(
                new Product("Cheese", 50, 2, LocalDate.of(2025, 7, 10), true, 0.3),
                new Product("Yogurt", 20, 2, LocalDate.of(2025, 7, 8), false, 0),
                new Product("TV", 3000, 1, null, true, 5.0),
                new Product("E-Book", 100, 1, null, false, 0)
        );

        Cart cart = new Cart();
        Customer customer = new Customer("customer", 10000);

        try{
            cart.add(products.get(0), 2);
            cart.add(products.get(1), 2);
            cart.add(products.get(2), 1);
            cart.add(products.get(3), 1);
            new CheckoutService(customer, cart);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n_____________________________________\n");
    }
}
