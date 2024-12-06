package fr.univtln.bruno.samples.cdi.producers;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

import jakarta.inject.Qualifier;

/**
 * A custom CDI qualifier annotation used to mark beans or injection points
 * that represent the maximum amount in a specific context.
 *
 * This annotation can be applied to fields, types, and methods.
 *
 * Usage example:
 *
 * <pre>
 * {@code
 * @Inject
 * @MaxAmount
 * private BigDecimal maxAmount;
 * }
 * </pre>
 *
 * @see javax.inject.Qualifier
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.Target
 */
@Qualifier
@Retention(RUNTIME)
@Target({PARAMETER, FIELD, TYPE, METHOD})
public @interface MaxAmount {}
