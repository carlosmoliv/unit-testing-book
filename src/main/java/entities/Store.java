package entities;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private final Map<Product, Integer> inventory = new HashMap<>();

    public void addInventory(Product product, int quantity) {
        inventory.put(product, quantity);
    }

    public int getInventory(Product product) {
        return inventory.getOrDefault(product, 0);
    }
}
