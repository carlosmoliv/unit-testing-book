package services;

import entities.Delivery;

import java.time.LocalDateTime;

public class DeliveryService {
    public boolean isDeliveryValid(Delivery delivery) {
        LocalDateTime twoDaysFromNow = LocalDateTime.now().plusDays(2);
        return delivery.getDate().isAfter(twoDaysFromNow);
    }
}
