package entities;

public class Customer2 {
    public boolean purchase(IStore store, Product product, int quantity) {
        if (store.hasEnoughInventory(product, quantity)) {
            store.removeInventory(product, quantity);
            return true;
        }
        return false;
    }
}