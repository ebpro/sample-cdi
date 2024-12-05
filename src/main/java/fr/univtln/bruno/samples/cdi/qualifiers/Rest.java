package fr.univtln.bruno.samples.cdi.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

import jakarta.inject.Qualifier;

/**
 * The @Rest annotation is a custom CDI (Contexts and Dependency Injection) qualifier.
 * It is used to distinguish between different beans that implement the same interface
 * or have the same type, allowing for more fine-grained dependency injection.
 * 
 * This annotation can be applied to methods, fields, parameters, and types.
 * 
 * Usage example:
 * 
 * <pre>
 * {@code
 * @Inject
 * @Rest
 * private MyService myService;
 * }
 * </pre>
 * 
 * In this example, the @Rest annotation is used to specify which implementation
 * of MyService should be injected.
 * 
 * Annotations:
 * - @Qualifier: Indicates that this annotation is a CDI qualifier.
 * - @Retention(RUNTIME): Specifies that this annotation will be available at runtime.
 * - @Target({METHOD, FIELD, PARAMETER, TYPE}): Specifies the kinds of program elements
 *   to which this annotation can be applied.
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface Rest {}