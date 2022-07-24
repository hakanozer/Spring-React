package com.works.configs;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", false);
        hm.put("errors", exceptionParser(ex) );
        return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", false);
        hm.put("errors", ex.getMethod() );
        return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
    }

    public List<Map<String, String>> exceptionParser(MethodArgumentNotValidException ex) {
        List<Map<String, String>> ls = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getFieldErrors();
        for ( FieldError error : fieldErrors ) {
            String item = error.getField(); // Field Name
            String message = error.getDefaultMessage();
            Map<String, String> hm = new HashMap<>();
            hm.put( item, message );
            ls.add(hm);
        }
        return ls;
    }


}
