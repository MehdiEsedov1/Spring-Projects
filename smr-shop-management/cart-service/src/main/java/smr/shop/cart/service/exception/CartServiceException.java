package smr.shop.cart.service.exception;

import org.springframework.http.HttpStatus;
import smr.shop.libs.common.exception.GlobalException;

public class CartServiceException extends GlobalException {

    public CartServiceException(String message, HttpStatus status) {
        super(message, status);
    }

    public CartServiceException(String message, HttpStatus status, Throwable cause) {
        super(message, status, cause);
    }

}
