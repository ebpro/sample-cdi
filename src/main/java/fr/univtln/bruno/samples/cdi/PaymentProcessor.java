package fr.univtln.bruno.samples.cdi;

import fr.univtln.bruno.samples.cdi.producers.MaxAmount;
import fr.univtln.bruno.samples.cdi.producers.MinAmount;
import fr.univtln.bruno.samples.cdi.qualifiers.PayPal;
import fr.univtln.bruno.samples.cdi.services.PaymentService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * The PaymentProcessor class is responsible for processing payments.
 * It uses a PaymentService implementation annotated with @PayPal.
 * This class is application-scoped, meaning it is a singleton within the CDI
 * container.
 * <p>
 * The processPayment method logs a message and delegates the payment processing
 * to the injected PaymentService.
 * <p>
 * Annotations:
 * - @ApplicationScoped: Indicates that this bean is application-scoped.
 * - @Slf4j: Lombok annotation to generate a logger field.
 * - @PayPal: Custom qualifier to specify the PayPal implementation of
 * PaymentService.
 * - @Inject: CDI annotation to inject the PaymentService dependency.
 */
@ApplicationScoped
@Slf4j
public class PaymentProcessor {

  private int indicativeMaxAmount;
  private int indicativeMinAmount;
  private PaymentService paymentService;

  public PaymentProcessor() {
  }

  @Inject
  public PaymentProcessor(@PayPal PaymentService paymentService, @MaxAmount int indicativeMaxAmount, @MinAmount int indicativeMinAmount) {
    this.paymentService = paymentService;
    this.indicativeMaxAmount = indicativeMaxAmount;
    this.indicativeMinAmount = indicativeMinAmount;
  }

  public String processPayment() {
    log.info("Processing payment...");
    return "Message: %s (Minimum amount: %s, Maximum amount:%s)".formatted(
      paymentService.processPayment(),
      indicativeMinAmount,
      indicativeMaxAmount);
  }
}
