package com.example.springsecuritypractical.Exception;

import io.jsonwebtoken.SignatureException; // Ensure correct import
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedException {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException ex) {
        return new ResponseEntity<>(new ExceptionResponse("Access Denied: " + ex.getMessage(), ex.getClass().getSimpleName()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ExceptionResponse> handleSignatureException(SignatureException ex) {
        return new ResponseEntity<>(new ExceptionResponse("JWT Error: " + ex.getMessage(), ex.getClass().getSimpleName()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)  // Catch-all for unhandled exceptions
    public ResponseEntity<ExceptionResponse> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(new ExceptionResponse("Unexpected Error: " + ex.getMessage(), ex.getClass().getSimpleName()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
