package com.pj.littlepig.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* getPigListByFactory(..))")
    private void anyOldTransfer() {
    }

    @AfterThrowing(
            pointcut = "anyOldTransfer()",
            throwing = "ex")
    public void doRecoveryActions(Exception ex) {
    }
}

