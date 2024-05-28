package dev.ashish.EcomOrderService.exception.UserException;

import dev.ashish.EcomOrderService.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFoundException(Exception ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage(), 404);

        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
