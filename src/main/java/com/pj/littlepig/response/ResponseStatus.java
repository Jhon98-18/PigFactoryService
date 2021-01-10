package com.pj.littlepig.response;

public enum ResponseStatus {
    OK(200, "成功"),
    WRONG(500, "请求异常"),
    OVERTIME(500,"token 超时");

    private final int status;
    private final String message;

    ResponseStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
