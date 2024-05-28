package dev.ashish.EcomOrderService.exception.UserException;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
