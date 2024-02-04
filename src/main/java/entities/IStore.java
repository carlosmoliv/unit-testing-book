package entities;

public interface IStore {
    boolean hasEnoughInventory(Product product, int quantity);
    void removeInventory(Product product, int quantity);
}
