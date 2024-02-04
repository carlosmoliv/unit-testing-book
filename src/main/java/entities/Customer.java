package entities;

public class Customer {
    public boolean purchase(Store store, Product product, int quantity) {
        int availableQuantity = store.getInventory(product);

        if (availableQuantity >= quantity) {
            store.addInventory(product, availableQuantity - quantity);
            return true;
        } else {
            return false;
        }
    }
}
