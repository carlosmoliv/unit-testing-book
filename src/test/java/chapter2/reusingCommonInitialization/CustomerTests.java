package chapter2.reusingCommonInitialization;

import org.junit.jupiter.api.Test;

// Extracting the common initialization code into private factory methods
public class CustomerTests extends IntegrationTests {
    @Test
    public void purchase_Succeeds_When_Enough_Inventory() {
        // use database here
    }
}
