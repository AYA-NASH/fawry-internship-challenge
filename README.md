# Fawry Quantum Internship Challenge

A simple Java-based e-commerce system built as part of Fawry's Full Stack Internship challenge.

### Overview

This project simulates a basic e-commerce system with the following features:
- Products can be **expirable** and/or **shippable**
- Customers add products to a **Cart**
- Checkout prints a **receipt** and handles:
  - Expired products
  - Out-of-stock
  - Insufficient balance
  - Empty cart
  - Shipping notice for shippable items

### Structure & Logic

- `Product`: Contains product details, expiry, and shipping info
- `Cart` and `CartItem`: Manages items added by the customer
- `Customer`: Holds user balance
- `CheckoutService`: Handles validation, payment, and printing output
- `ShippingService`: Ships items that implement the `Shippable` interface
- `tests/`: Includes multiple test cases for success and edge cases

### Sapmple Console's Output
Psudo-code:
```
  cart.add(Cheese, 2);
  cart.add(Yogurt, 2);
  cart.add(TV, 1);
  cart.add(E-Book, 1);
  checkout(customer, cart);
```
console output:
```
** Shipment notice **
2x Cheese         600.0g
1x TV         5000.0g
Total package weight: 5.6kg

** Checkout receipt **
2x Cheese    100.0
2x Yogurt    40.0
1x TV    3000.0
1x E-Book    100.0
-------------
Subtotal: 3240.0
Shipping: 30
Amount: 3270.0
Customer balance after payment: 6730.0
```
**This sample is tested in `tests/TestCase6.java`**
