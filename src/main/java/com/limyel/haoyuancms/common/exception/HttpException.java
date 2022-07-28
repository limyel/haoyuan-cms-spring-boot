package com.limyel.haoyuancms.common.exception;

import java.awt.*;

public class HttpException extends RuntimeException {

    protected Integer code;

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

}
