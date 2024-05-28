package dev.ashish.EcomOrderService.service;

import dev.ashish.EcomOrderService.dto.OrderRequestDTO;
import dev.ashish.EcomOrderService.dto.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO requestDTO);
}
