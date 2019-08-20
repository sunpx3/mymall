package com.sunpx.mall.exceptions;

public class UsernameLockException extends RuntimeException {
    private int value;
    public UsernameLockException(){
        super();
    }
    public UsernameLockException(String message) {
        super(message);
    }

    public UsernameLockException(String msg,int value) {
        super(msg);
        this.value=value;
    }
    public int getValue() {
        return value;
    }
}
