package com.pj.littlepig.response;

import static com.pj.littlepig.response.ResponseStatus.OK;

public class ResponseEntity<T> {
    private Integer status;
    private String message;
    private Long timeStamp;
    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseEntity(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
        this.data = data;
    }

    public ResponseEntity(T data) {
        this.status = 200;
        this.timeStamp = System.currentTimeMillis();
        this.data = data;
    }

    public ResponseEntity(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public ResponseEntity(String message) {
        this.status = 500;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public ResponseEntity(ResponseStatus responseStatus) {
        this(responseStatus.getStatus(), responseStatus.getMessage());
    }

    public ResponseEntity() {
    }

}
