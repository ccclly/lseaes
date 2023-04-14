package com.cly.lseaes.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cly.lseaes.constant.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e) {
        int stateCode = 500;
        switch (e.getMessage()) {
            case ErrorMessage.ACCOUNT_NOT_FOUND: stateCode = HttpStatus.NOT_FOUND.value();
                break;
            case ErrorMessage.PASSWORD_ERROR:
            case ErrorMessage.USER_NOT_LOGIN:
                stateCode = 403;
                break;
        }
        return new ErrorResponse(stateCode, e.getMessage());
    }
}
