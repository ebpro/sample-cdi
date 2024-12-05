package fr.univtln.bruno.samples.cdi.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

import jakarta.inject.Qualifier;

/**
 * This annotation is a custom CDI (Contexts and Dependency Injection) qualifier.
 * It is used to distinguish between different beans of the same type.
 * 
 * The @Qualifier annotation indicates that this is a CDI qualifier.
 * The @Retention(RUNTIME) annotation specifies that this annotation will be available at runtime.
 * The @Target({METHOD, FIELD, PARAMETER, TYPE}) annotation specifies the contexts in which this annotation can be used.
 * 
 * Use this annotation to mark beans, methods, fields, or parameters that are related to WebSocket functionality.
 * 
 * Example usage:
 * 
 * {@code
 * @Inject
 * @Websocket
 * private SomeWebSocketService websocketService;
 * }
 * 
 * This will inject the appropriate WebSocket service implementation.
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface Websocket{}