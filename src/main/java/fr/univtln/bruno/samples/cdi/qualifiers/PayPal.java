package fr.univtln.bruno.samples.cdi.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

import jakarta.inject.Qualifier;

/**
 * The @PayPal annotation is a custom CDI (Contexts and Dependency Injection) qualifier.
 * It is used to distinguish between different implementations of a bean type.
 * 
 * This annotation can be applied to methods, fields, parameters, and types.
 * 
 * Usage example:
 * 
 * <pre>
 * {@code
 * @Inject
 * @PayPal
 * private PaymentService paymentService;
 * }
 * </pre>
 * 
 * This will inject the PayPal-specific implementation of the PaymentService.
 * 
 * Annotations:
 * - @Qualifier: Indicates that this annotation is a CDI qualifier.
 * - @Retention(RUNTIME): Specifies that this annotation will be available at runtime.
 * - @Target({METHOD, FIELD, PARAMETER, TYPE}): Specifies the kinds of program elements to which this annotation can be applied.
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface PayPal {}