package chapter2.reusingTextFixtures;

import entities.Customer;
import entities.Product;
import entities.Store;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

// Extracting the common initialization code into private factory methods
public class CustomerTests {
    @Test
    public void purchase_succeeds_when_enough_inventory() {
        // Arrange
        Store store = createStoreWithInventory(Product.Shampoo, 10);
        Customer customer = createCustomer();

        // Act
        boolean success = customer.purchase(store, Product.Shampoo, 5);

        // Assert
        assertTrue(success);
        assertEquals(5, store.getInventory(Product.Shampoo));
    }

    @Test
    public void purchase_fails_when_not_enough_inventory() {
        // Arrange
        Store store = createStoreWithInventory(Product.Shampoo, 10);
        Customer customer = createCustomer();

        // Act
        boolean success = customer.purchase(store, Product.Shampoo, 15);

        // Assert
        assertFalse(success);
        assertEquals(10, store.getInventory(Product.Shampoo));
    }

    private Store createStoreWithInventory(Product product, int quantity) {
        Store store = new Store();
        store.addInventory(product, quantity);
        return store;
    }

    private Customer createCustomer() {
        return new Customer();
    }
}
