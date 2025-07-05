package org.example.shipping;

import java.util.List;

public class ShippingService {
    public  static void ship(List<Shippable> itemsToShip){
        if(itemsToShip.isEmpty()){
            System.out.println("No Items need Shipping");
            return;
        }

        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : itemsToShip) {
            System.out.println(item.getName() + "         " + (item.getWeight() * 1000) + "g");
            totalWeight += item.getWeight();
        }

        System.out.println("Total package weight: " + totalWeight + "kg\n");
    }
}
