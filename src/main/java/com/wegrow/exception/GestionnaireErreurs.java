package com.wegrow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GestionnaireErreurs {

    @ExceptionHandler(ConflitException.class)
    public ResponseEntity<Map<String, String>> conflit(ConflitException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("erreur", e.getMessage()));
    }

    @ExceptionHandler(ResourceIntrouvableException.class)
    public ResponseEntity<Map<String, String>> introuvable(ResourceIntrouvableException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erreur", e.getMessage()));
    }
}