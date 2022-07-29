package com.limyel.haoyuancms.common.exception;

import com.limyel.haoyuancms.common.api.Result;

import java.awt.*;

public class HttpException extends RuntimeException {

    protected Integer code = Result.INTERNAL_SERVER_ERROR_CODE;

    protected Integer httpStatusCode = 500;

    public Integer getCode() {
        return this.code;
    }

    public Integer getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public HttpException(int code) {
        this.code = code;
    }

    public HttpException() {
    }

}
