package chapter2.namingGuidelines;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import entities.Delivery;
import services.DeliveryService;

public class DeliveryTests {
    @Test
    // Bad description
    // public void isDelivery_InvalidDate_ReturnsFalse()

    // First refactor: Good first try, but not good yet, but at least makes more sense to a non-programmer and the SUT method is no longer part of the name
    // public void delivery_with_invalid_date_should_be_considered_invalid()

    // Second refactor: This one is better but too verbose
    // public void delivery_with_past_date_should_be_considered_invalid()

    // Third refactor: Getting rid of the word considered
    // public void delivery_with_past_date_should_be_invalid()

    // Fourth refactor: Removing the word "should be" because there’s no place for a wish or a desire when stating a fact
    // public void delivery_with_past_date_is_invalid()

    // Fifth and last version: Adding the article "a" to improve the english grammar readability
    // public void delivery_with_a_past_date_is_invalid()

    public void delivery_with_a_past_date_is_invalid() {
        DeliveryService sut = new DeliveryService();
        LocalDateTime pastDate = LocalDateTime.now().minusDays(1);
        Delivery delivery = new Delivery();
        delivery.setDate(pastDate);

        boolean isValid = sut.isDeliveryValid(delivery);

        assertFalse(isValid);
    }
}
