package com.doctor.doctor.exception;

import com.doctor.doctor.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ApiErrorResponse handleEntityNotFoundException(NotFoundException ex) {

        return getApiErrorResponse(ex);
    }

    private ApiErrorResponse getApiErrorResponse(Exception ex) {

        return ApiErrorResponse.builder().message(ex.getMessage()).build();
    }
}
