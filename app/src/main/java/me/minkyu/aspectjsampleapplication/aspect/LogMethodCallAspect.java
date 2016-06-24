package me.minkyu.aspectjsampleapplication.aspect;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogMethodCallAspect {
    private static final String TAG = LogMethodCallAspect.class.getSimpleName();

    @Pointcut("execution(@me.minkyu.aspectjsampleapplication.annotations.LogMethodCall * *(..))")
    public void methodWithLogMethodCallAnnotation() { }

    @Around("methodWithLogMethodCallAnnotation()")
    public void logOnMethodCall(final ProceedingJoinPoint joinPoint) throws Throwable {
        Log.i(TAG, "Method call occurred.");

        joinPoint.proceed();
    }
}
