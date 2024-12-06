package fr.univtln.bruno.samples.cdi.services.decorators;

import fr.univtln.bruno.samples.cdi.services.PaymentService;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * PaymentServiceDecorator is a CDI decorator that adds additional behavior to the PaymentService.
 * It uses the @Decorator annotation to indicate that it is a decorator and the @Inject, @Delegate,
 * and @Any annotations to inject the delegate PaymentService implementation.
 * <p>
 * This decorator logs messages before and after the execution of the processPayment method.
 * <p>
 * Usage:
 * - Ensure that there is an implementation of PaymentService available for injection.
 * - The decorator will automatically wrap the PaymentService implementation and add logging.
 * <p>
 * Annotations:
 * - @Decorator: Indicates that this class is a CDI decorator.
 * - @Slf4j: Lombok annotation to generate a logger instance.
 * - @Inject: Injects the delegate PaymentService implementation.
 * - @Delegate: Indicates the delegate object that the decorator wraps.
 * - @Any: Qualifier to indicate that any implementation of PaymentService can be injected.
 * <p>
 * Methods:
 * - processPayment(): Logs messages before and after calling the delegate's processPayment method.
 */
@Decorator
@Slf4j
public abstract class PaymentServiceDecorator implements PaymentService {
  private PaymentService paymentService;

  @Inject
  protected PaymentServiceDecorator(@Delegate @Any PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @Override
  public String processPayment() {
    // Additional logic before
    log.info("Start of decorator");
    String result = paymentService.processPayment().toUpperCase();
    // Additional logic after
    log.info("End of decorator");

    return result;
  }
}
