package com.algaworks.algafoodapi.controller.exception;


import com.algaworks.algafoodapi.service.exception.DataBaseIntegrety;
import com.algaworks.algafoodapi.service.exception.EntidadeNaoEncontrada;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> teste(){
        return ResponseEntity.ok().body("teste de captura de sinal");
    }



    @ExceptionHandler(DataBaseIntegrety.class)
    public ResponseEntity<StandardError> DataIntegrety(DataBaseIntegrety e , HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Integrety Data");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(EntidadeNaoEncontrada.class)
    public ResponseEntity<StandardError> EntidadeNaoEncontrada(EntidadeNaoEncontrada e , HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Integrety Data");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


}
