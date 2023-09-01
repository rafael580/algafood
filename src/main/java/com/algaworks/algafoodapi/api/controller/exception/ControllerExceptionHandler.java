package com.algaworks.algafoodapi.api.controller.exception;


import com.algaworks.algafoodapi.api.service.exception.DataBaseIntegrety;
import com.algaworks.algafoodapi.api.service.exception.EntidadeNaoEncontrada;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @Autowired
    private MessageSource messageSource;

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
        err.setError("Entidade nao encontrada");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e , HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Integrety Data");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()){
            String message = messageSource.getMessage(f, LocaleContextHolder.getLocale());
            err.addError(f.getField(),message);
        }

        return ResponseEntity.status(status).body(err);
    }

}
