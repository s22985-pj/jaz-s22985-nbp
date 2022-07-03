package com.example.jazs22985nbp;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class JazS22985NbpRestControllerErr {
    @ExceptionHandler(HttpClientErrorException.class)
    ResponseEntity<String> HandlerRuntimeException(HttpClientErrorException exception) {
        switch (exception.getStatusCode()){
            case INTERNAL_SERVER_ERROR:
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception throw: 123");
            case NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exception throw: 234");
            case BAD_REQUEST:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception Throw: 345");
            case NO_CONTENT:
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Exception Throw: 456");
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception Throw: 567");
    }

}
