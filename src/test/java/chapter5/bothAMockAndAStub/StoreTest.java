package chapter5.bothAMockAndAStub;

import entities.Customer2;
import entities.IStore;
import entities.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class StoreTest {
    // The below test is both a mock and a stub
    // It returns a mocked response ad verifies a method call
    // Sets up the answer from HasEnoughInventory() and verifies the call to RemoveInventory()
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
}