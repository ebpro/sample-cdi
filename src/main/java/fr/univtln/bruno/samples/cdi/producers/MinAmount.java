package fr.univtln.bruno.samples.cdi.producers;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

import jakarta.inject.Qualifier;

/**
 * This annotation is a CDI (Contexts and Dependency Injection) qualifier.
 * It is used to mark a field, type, or method for injection with a specific
 * implementation or instance that is qualified by this annotation.
 * 
 * The @Qualifier annotation indicates that this is a custom qualifier.
 * The @Retention(RUNTIME) annotation specifies that this annotation will be
 * available at runtime.
 * The @Target({FIELD, TYPE, METHOD}) annotation specifies that this annotation
 * can be applied to fields, types (classes or interfaces), and methods.
 */
@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
public @interface MinAmount {}