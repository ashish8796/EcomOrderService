package dev.ashish.EcomOrderService.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionDTO {
    private String message;
    private int code;

    public ExceptionDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
