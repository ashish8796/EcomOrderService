package dev.ashish.EcomOrderService.client;

import dev.ashish.EcomOrderService.dto.PaymentRequestDTO;
import dev.ashish.EcomOrderService.dto.PaymentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    private String paymentClientAPIBaseUrl;
    private String paymentClientAPIPayPath;

    public PaymentResponseDTO pay(PaymentRequestDTO requestDTO) {
        String url = paymentClientAPIBaseUrl.concat(paymentClientAPIPayPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<PaymentResponseDTO> responseDTO = restTemplate.postForEntity(url, requestDTO, PaymentResponseDTO.class);

        return responseDTO.getBody();
    }
}
