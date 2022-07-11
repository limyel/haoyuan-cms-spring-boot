package com.limyel.haoyuancms.common.api;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1L;

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
        return new Result<T>(RetCode.SUCCESS.getCode(), RetCode.SUCCESS.getMsg());
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(RetCode.SUCCESS.getCode(), RetCode.SUCCESS.getMsg(), data);
    }

    public static <T extends Serializable> Result<T> success(String msg, T data) {
        return new Result<T>(RetCode.SUCCESS.getCode(), msg, data);
    }

    public static <T extends Serializable> Result<T> successMsg(String msg) {
        return new Result<T>(RetCode.SUCCESS.getCode(), msg);
    }

    public static <T extends Serializable> Result<T> failed() {
        return new Result<T>(RetCode.FAILED.getCode(), RetCode.FAILED.getMsg());
    }

    public static <T extends Serializable> Result<T> failed(T data) {
        return new Result<T>(RetCode.FAILED.getCode(), RetCode.FAILED.getMsg(), data);
    }

    public static <T extends Serializable> Result<T> failedMsg(String msg) {
        return new Result<T>(RetCode.FAILED.getCode(), msg);
    }

}
