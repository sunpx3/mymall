package com.sunpx.mall.common;

import lombok.Data;

/**
 * 通用返回对象
 * Created by macro on 2019/4/19.
 */
@Data
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    /**
     * 用户密码错误
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> badCredentialsException(T data){
        return new CommonResult<T>(ResultCode.BAD_CREDENTIALS_EXCEPTION.getCode(), ResultCode.BAD_CREDENTIALS_EXCEPTION.getMessage(), data);
    }

    public static <T> CommonResult<T> badCredentialsException(String message){
        return new CommonResult<T>(ResultCode.BAD_CREDENTIALS_EXCEPTION.getCode(), message, null);
    }

    /**
     * 用户或密码不存在
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> userNameOrPasswordNotnullException(T data){
        return new CommonResult<T>(ResultCode.USERNAME_OR_PASSWORD_NOTNULL_EXCEPTION.getCode(), ResultCode.USERNAME_OR_PASSWORD_NOTNULL_EXCEPTION.getMessage(), data);
    }

    public static <T> CommonResult<T> userNameOrPasswordNotnullException(String message){
        return new CommonResult<T>(ResultCode.USERNAME_OR_PASSWORD_NOTNULL_EXCEPTION.getCode(), message, null);
    }
}
