package org.trackcoin.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.trackcoin.exception.CurrencyAlreadyRegisteredException;
import org.trackcoin.exception.EntityNotFoundException;
import org.trackcoin.message.ResponseMessage;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseMessage> entityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }

    @ExceptionHandler(CurrencyAlreadyRegisteredException.class)
    public ResponseEntity<ResponseMessage> currencyAlreadyRegisteredException(CurrencyAlreadyRegisteredException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }


}
