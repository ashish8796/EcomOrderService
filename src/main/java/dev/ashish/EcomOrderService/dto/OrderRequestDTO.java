package dev.ashish.EcomOrderService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderRequestDTO {
    private double amount;
    private UUID userId;
    private List<UUID> productIds;
    private String currencyTag;
}
