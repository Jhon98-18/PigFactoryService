package com.pj.littlepig.response;

public enum ResponseStatus {
    OK(200, "成功");
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
