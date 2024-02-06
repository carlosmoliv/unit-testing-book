package chapter2.londonStyle;

import entities.Customer2;
import entities.IStore;
import entities.Product;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Tests written using the London style of unit testing
public class StoreTest {
    @Test
    public void purchase_succeeds_when_enough_inventory() {
        // Arrange
        IStore storeMock = mock(IStore.class);
        when(storeMock.hasEnoughInventory(Product.Shampoo, 5)).thenReturn(true);
        Customer2 customer = new Customer2();

        // Act
        boolean success = customer.purchase(storeMock, Product.Shampoo, 5);

        // Assert
        assertTrue(success);
        verify(storeMock, times(1)).removeInventory(Product.Shampoo, 5);
    }

    @Test
    public void purchase_fails_when_not_enough_inventory() {
        // Arrange
        IStore storeMock = mock(IStore.class);
        when(storeMock.hasEnoughInventory(Product.Shampoo, 5)).thenReturn(false);
        Customer2 customer = new Customer2();

        // Act
        boolean success = customer.purchase(storeMock, Product.Shampoo, 5);

        // Assert
        assertFalse(success);
        verify(storeMock, times(0)).removeInventory(Product.Shampoo, 5);
    }
}