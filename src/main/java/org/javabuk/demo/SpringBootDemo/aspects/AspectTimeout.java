package org.javabuk.demo.SpringBootDemo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Aspect
@Component
public class AspectTimeout {

    @Value("${app.timeout.seconds}")
    private Integer segundosTimeout;

    @Around("@annotation(timeOut)")
    public Object excepcions(ProceedingJoinPoint joinPoint, TimeOut timeOut) throws Throwable {
        Object objetoDevuelvo = null;
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            Callable<Object> task = () -> {
                try {
                    return joinPoint.proceed();
                } catch (Throwable throwable) {
                    throw new Exception(throwable);
                }
            };
            Future<Object> future = executor.submit(task);
            try {

                objetoDevuelvo = future.get(segundosTimeout, TimeUnit.SECONDS);

            } catch (TimeoutException | InterruptedException | ExecutionException ex) {
                throw new Exception("Timeout");
            } finally {
                future.cancel(true);
            }
            executor.shutdown();
        }catch (Exception e){
            throw e;
        }
        return objetoDevuelvo;

    }

}
