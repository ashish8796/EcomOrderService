package dev.ashish.EcomOrderService.controller;

import dev.ashish.EcomOrderService.dto.OrderRequestDTO;
import dev.ashish.EcomOrderService.dto.OrderResponseDTO;
import dev.ashish.EcomOrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO requestDTO) {
        OrderResponseDTO responseDTO = orderService.createOrder(requestDTO);

        return ResponseEntity.ok().body(responseDTO);
    }

}
