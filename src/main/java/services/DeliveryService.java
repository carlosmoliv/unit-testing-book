package services;

import entities.Delivery;

import java.time.LocalDateTime;

public class DeliveryService {
    public boolean isDeliveryValid(Delivery delivery) {
        return delivery.getDate().isAfter(LocalDateTime.now());
    }
}
