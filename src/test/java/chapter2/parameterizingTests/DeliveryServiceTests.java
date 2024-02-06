package chapter2.parameterizingTests;

import entities.Delivery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import services.DeliveryService;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

// A test that encompasses several facts
// Two tests verifying the positive and negative scenarios
public class DeliveryServiceTests {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void can_detect_an_invalid_delivery_date(int daysFromNow) {
        DeliveryService sut = new DeliveryService();
        LocalDateTime deliveryDate = LocalDateTime.now().plusDays(daysFromNow);
        Delivery delivery = new Delivery();
        delivery.setDate(deliveryDate);

        boolean isValid = sut.isDeliveryValid(delivery);

        assertFalse(isValid);
    }

    @Test
    public void The_soonest_delivery_date_is_two_days_from_now() {
        DeliveryService sut = new DeliveryService();
        LocalDateTime deliveryDate = LocalDateTime.now().plusDays(2);
        Delivery delivery = new Delivery();
        delivery.setDate(deliveryDate);

        boolean isValid = sut.isDeliveryValid(delivery);

        assertFalse(isValid);
    }
}
