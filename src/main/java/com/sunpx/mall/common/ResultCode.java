package com.sunpx.mall.common;

/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),

    USERNAME_OR_PASSWORD_NOTNULL_EXCEPTION(10001,"用户名或密码不能为空!"),
    USERNAME_NOT_FOUND_EXCEPTION(10002,"该用户不存在!"),
    BAD_CREDENTIALS_EXCEPTION(10004,"用户名密码错误!");


    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }
    public long getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
