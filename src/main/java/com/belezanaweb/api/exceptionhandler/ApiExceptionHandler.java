package com.belezanaweb.api.exceptionhandler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.belezanaweb.domain.exception.ProductNotFoundException;
import com.belezanaweb.domain.exception.SkuAlreadyExistsException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.OffsetDateTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SkuAlreadyExistsException.class)
    public ResponseEntity<?> handleSkuNotAllowed(SkuAlreadyExistsException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFound(ProductNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> handleEmptyResultDataAcess(EmptyResultDataAccessException ex, WebRequest request) {
        var message = String.format("Unable to delete product with this id. %d results. ", ex.getActualSize());
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
        var rootCause = ExceptionUtils.getRootCause(ex);
        if (rootCause instanceof SQLIntegrityConstraintViolationException)
            return handleSQLIntegrityCosntraintViolation
                    (ex, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        return handleExceptionInternal(ex, "Violation of data integrity.", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private ResponseEntity<?> handleSQLIntegrityCosntraintViolation
            (DataIntegrityViolationException ex, HttpHeaders httpHeaders, HttpStatus badRequest, WebRequest request) {
        var body = ProblemDetails.builder().status(badRequest.value())
                .timeStamp(OffsetDateTime.now()).detail(ex.getLocalizedMessage()).build();
        return handleExceptionInternal(ex, body, httpHeaders, badRequest, request);
    }

}