package br.com.site923a.webserver;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        e.getStackTrace();
        
        RetornoErro retorno = new RetornoErro(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity
            .status(retorno.getErro())
            .body(retorno.getMensagem());
    }

}
