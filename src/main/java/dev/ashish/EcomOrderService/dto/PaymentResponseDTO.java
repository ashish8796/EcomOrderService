package dev.ashish.EcomOrderService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PaymentResponseDTO {
    private UUID orderId;
    private UUID userId;
    private double amount;
    private String paymentStatus;
    private List<UUID> paymentIds;

    public static OrderResponseDTO from (PaymentResponseDTO responseDTO) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        orderResponseDTO.setPaymentIds(responseDTO.getPaymentIds());
        return null;
    }
}
