package chapter2.classicalStyle;

import entities.Customer;
import entities.Product;
import entities.Store;
import org.junit.Test;
import static org.junit.Assert.*;

// Tests written using the classical style of unit testing
public class StoreTest {
    @Test
    public void purchase_succeeds_when_enough_inventory() {
        // Arrange
        Store store = new Store();
        store.addInventory(Product.Shampoo, 10);
        Customer customer = new Customer();

        // Act
        boolean success = customer.purchase(store, Product.Shampoo, 5);

        // Assert
        assertTrue(success);
        assertEquals(5, store.getInventory(Product.Shampoo));
    }

    @Test
    public void purchase_fails_when_not_enough_inventory() {
        // Arrange
        Store store = new Store();
        store.addInventory(Product.Shampoo, 10);
        Customer customer = new Customer();

        // Act
        boolean success = customer.purchase(store, Product.Shampoo, 15);

        // Assert
        assertFalse(success);
        assertEquals(10, store.getInventory(Product.Shampoo));
    }
}
