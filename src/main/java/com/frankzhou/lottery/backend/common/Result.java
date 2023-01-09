package com.frankzhou.lottery.backend.common;

import com.frankzhou.lottery.backend.common.constants.ResultCodeConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* @Author: this.FrankZhou
* @Description: 前端统一结果返回类
* @DateTime: 2023/1/8 1:12
*/
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 123839L;

    private T data;
    private String code;
    private String msg;

    public static <T> Result<T> success() {
        return getResult(ResultCodeConstants.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return getResult(data,ResultCodeConstants.SUCCESS);
    }

    public static <T> Result<T> error() {
        return getResult(ResultCodeConstants.SERVER_ERROR);
    }

    public static <T> Result<T> error(ResultCode resultCode) {
        return getResult(resultCode);
    }

    public static <T> Result<T> getResult(ResultCode resultCode) {
        return getResult(null,resultCode);
    }

    public static <T> Result<T> getResult(T data,ResultCode resultCode) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        return result;
    }
}
