package fr.univtln.bruno.samples.cdi.services.interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.extern.slf4j.Slf4j;

/**
 * LoggingInterceptor is an interceptor that logs the entry and exit of methods.
 * It uses the SLF4J logging framework to log method names when they are invoked and when they exit.
 * 
 * <p>This interceptor is annotated with {@link Interceptor} and {@link Logging} annotations.
 * The {@link AroundInvoke} annotation is used to define the method that will be called around the invocation of the intercepted method.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @Logging
 * public void someMethod() {
 *     // method implementation
 * }
 * }
 * </pre>
 * 
 * <p>When {@code someMethod} is called, the interceptor will log the entry and exit of the method.</p>
 * 
 * @see Interceptor
 * @see Logging
 * @see AroundInvoke
 */
@Interceptor
@Logging

@Slf4j
public class LoggingInterceptor {
    @AroundInvoke
    public Object logMethod(InvocationContext ctx) throws Exception {
        log.info("Entering method: " + ctx.getMethod().getName());
        try {
            return ctx.proceed();
        } finally {
            log.info("Exiting method: " + ctx.getMethod().getName());
        }
    }
}
