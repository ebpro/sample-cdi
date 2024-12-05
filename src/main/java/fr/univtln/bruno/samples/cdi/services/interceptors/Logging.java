package fr.univtln.bruno.samples.cdi.services.interceptors;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

/**
 * This annotation is used to mark classes, methods, or constructors for logging purposes.
 * It is an interceptor binding annotation, which means it can be used to define 
 * interceptor methods that will be invoked when the annotated elements are accessed.
 * 
 * Usage:
 * - Apply this annotation to a class, method, or constructor to enable logging.
 * 
 * Example:
 * <pre>
 * {@code
 * @Logging
 * public void someMethod() {
 *     // method implementation
 * }
 * }
 * </pre>
 * 
 * @see javax.interceptor.InterceptorBinding
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.Target
 */
@InterceptorBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD, CONSTRUCTOR})
public @interface Logging {}
