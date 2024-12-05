package fr.univtln.bruno.samples.cdi.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

import jakarta.inject.Qualifier;

/**
 * The @CreditCard annotation is a custom CDI (Contexts and Dependency Injection) qualifier.
 * 
 * This annotation can be used to qualify beans, injection points, and other CDI artifacts
 * to indicate that they are related to credit card processing or handling.
 * 
 * It can be applied to methods, fields, parameters, and types.
 * 
 * Usage example:
 * 
 * <pre>
 * {@code
 * @Inject
 * @CreditCard
 * private PaymentProcessor paymentProcessor;
 * }
 * </pre>
 * 
 * This helps in distinguishing between different implementations of the same type
 * and allows for more fine-grained control over dependency injection.
 * 
 * Annotations:
 * - @Qualifier: Indicates that this annotation is a CDI qualifier.
 * - @Retention(RUNTIME): Specifies that this annotation is available at runtime.
 * - @Target({METHOD, FIELD, PARAMETER, TYPE}): Specifies the possible targets where this annotation can be applied.
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface CreditCard {}
