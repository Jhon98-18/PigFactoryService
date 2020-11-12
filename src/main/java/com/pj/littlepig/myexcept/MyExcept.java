package com.pj.littlepig.myexcept;

import com.pj.littlepig.response.ResponseEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

public class MyExcept {
    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyExcept(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public MyExcept() {
    }
}

