package dev.ashish.EcomOrderService.dto;

import dev.ashish.EcomOrderService.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderResponseDTO {
    private UUID orderId;
    private UUID userId;
    private List<UUID> productIds;
    private double amount;
    private String transactionId;
    private List<UUID> paymentIds;
    private String orderStatus;

    public static OrderResponseDTO from (Order order) {
        OrderResponseDTO responseDTO = new OrderResponseDTO();

        responseDTO.setOrderId(order.getId());
        responseDTO.setOrderStatus(order.getOrderStatus().toString());
        responseDTO.setAmount(order.getAmount());
        responseDTO.setPaymentIds(order.getPaymentId());
        responseDTO.setUserId(order.getUserId());
        responseDTO.setProductIds(order.getProductIds());
        responseDTO.setTransactionId(order.getTransactionId());

        return responseDTO;
    }
}
