package dev.ashish.EcomOrderService.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class PaymentRequestDTO {
    private double amount;
    private UUID userId;
    private UUID orderId;
    private String currencyTag;

    public static PaymentRequestDTO from(OrderRequestDTO requestDTO, UUID orderId) {
        PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();

        paymentRequestDTO.setAmount(requestDTO.getAmount());
        paymentRequestDTO.setUserId(requestDTO.getUserId());
        paymentRequestDTO.setOrderId(orderId);
        paymentRequestDTO.setCurrencyTag(requestDTO.getCurrencyTag());

        return paymentRequestDTO;
    }
}
