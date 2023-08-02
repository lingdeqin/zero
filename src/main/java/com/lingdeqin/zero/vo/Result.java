package com.lingdeqin.zero.vo;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> ok() {
        return build(0, "成功！", null);
    }

    public static <T> Result<T> ok(T data) {
        return build(0, "成功！", data);
    }

    public static <T> Result<T> ok(T data, String message) {
        return build(0, message, data);
    }

    public static <T> Result<T> fail(String message) {
        return build(1, message, null);
    }

    private static <T> Result<T> build(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
