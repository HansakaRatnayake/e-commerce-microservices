package com.lezord.customer_service.advisers;

import com.lezord.customer_service.exception.CustomerNotFoundException;
import com.lezord.customer_service.util.StandardResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<StandardResponseDTO> handleCustomerNotFoundException(CustomerNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new StandardResponseDTO(
                        400,
                        exception.getMessage(),
                        exception
                ));
    }
}
