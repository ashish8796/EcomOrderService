package dev.ashish.EcomOrderService.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Order extends BaseModel{
    private UUID userId;
    private double amount;
    @ElementCollection
    private List<UUID> productIds;
    @ElementCollection
    private List<UUID> paymentId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
