package com.limyel.haoyuancms.common.exception;

import com.limyel.haoyuancms.common.api.Result;
import com.limyel.haoyuancms.common.config.ExceptionCodeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionCodeConfig exceptionCodeConfig;

    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result handleException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return new Result<>(Result.INTERNAL_SERVER_ERROR_CODE, Result.INTERNAL_SERVER_ERROR_MSG);
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<Result> handleHttpException(HttpServletRequest request, HttpException e) {
        e.printStackTrace();
        Result result = new Result(e.getCode(), exceptionCodeConfig.getMessage(e.getCode()));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());

        return new ResponseEntity<>(result, httpHeaders, httpStatus);
    }

}
