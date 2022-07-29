package com.limyel.haoyuancms.common.api;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    public static final Integer INTERNAL_SERVER_ERROR_CODE = 9999;

    public static final String INTERNAL_SERVER_ERROR_MSG = "服务器异常";

    public static final Integer SUCCESS_CODE = 0;

    public static final String SUCCESS_MSG = "成功";

    public static final Integer FAILED_CODE = 1;

    public static final String FAILED_MSG = "失败";

    private int code;
    private String msg;
    private T data;

    public Result() {}

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<T>(SUCCESS_CODE, SUCCESS_MSG);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T extends Serializable> Result<T> success(String msg, T data) {
        return new Result<T>(SUCCESS_CODE, msg, data);
    }

    public static <T extends Serializable> Result<T> successMsg(String msg) {
        return new Result<T>(SUCCESS_CODE, msg);
    }

    public static <T extends Serializable> Result<T> failed() {
        return new Result<T>(FAILED_CODE, FAILED_MSG);
    }

    public static <T extends Serializable> Result<T> failed(T data) {
        return new Result<T>(FAILED_CODE, FAILED_MSG, data);
    }

    public static <T extends Serializable> Result<T> failedMsg(String msg) {
        return new Result<T>(FAILED_CODE, msg);
    }

}
