package dev.ashish.EcomOrderService.service;

import dev.ashish.EcomOrderService.client.PaymentClient;
import dev.ashish.EcomOrderService.client.UserClient;
import dev.ashish.EcomOrderService.dto.OrderRequestDTO;
import dev.ashish.EcomOrderService.dto.OrderResponseDTO;
import dev.ashish.EcomOrderService.dto.PaymentRequestDTO;
import dev.ashish.EcomOrderService.dto.PaymentResponseDTO;
import dev.ashish.EcomOrderService.entity.Order;
import dev.ashish.EcomOrderService.entity.OrderStatus;
import dev.ashish.EcomOrderService.entity.PaymentStatus;
import dev.ashish.EcomOrderService.exception.UserException.UserNotFoundException;
import dev.ashish.EcomOrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private UserClient userClient;

    @Override
    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO requestDTO) {
        if(userClient.doesUserExists(requestDTO.getUserId())) {

            Order order = new Order();

            order.setAmount(requestDTO.getAmount());
            order.setUserId(requestDTO.getUserId());
            order.setProductIds(requestDTO.getProductIds());

            try {
                order.setOrderStatus(OrderStatus.PENDING);
                order = orderRepository.save(order);

                PaymentResponseDTO paymentResponseDTO = paymentClient.pay(PaymentRequestDTO.from(requestDTO, order.getId()));

                if (paymentResponseDTO.getPaymentStatus().equals(PaymentStatus.SUCCESS)) {
                    order.setOrderStatus(OrderStatus.SUCCESS);
                    order.setPaymentId(paymentResponseDTO.getPaymentIds());
                } else {
                    order.setOrderStatus(OrderStatus.FAILED);
                }

                order = orderRepository.save(order);
            } catch (Exception e) {
                order.setOrderStatus(OrderStatus.FAILED);
                order = orderRepository.save(order);

                System.out.println(e.getMessage());
            }

            return OrderResponseDTO.from(order);
        } else {
            throw new UserNotFoundException("User doesn't exists with userId: " + requestDTO.getUserId());
        }
    }
}
