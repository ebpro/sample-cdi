package fr.univtln.bruno.samples.cdi;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 * Main class demonstrating the use of CDI (Contexts and Dependency Injection) with Weld.
 * <p>
 * This class contains two parts:
 * <p>
 * 1. A method that works only if the Weld CDI engine is already started (e.g., in a Maven environment).
 * - The `paymentProcessor` is injected using the `@Inject` annotation.
 * - The `startup` method is triggered when the CDI container is initialized, processing the payment.
 * <p>
 * 2. A main method that manually initializes the Weld CDI container.
 * - The Weld container is started and the `PaymentProcessor` bean is retrieved and used to process the payment.
 * <p>
 * Note: Ensure that Weld is properly configured and included in your project dependencies.
 */
@Slf4j
public class Main {

  /* This part works only if Weld (CDI engine is already started for instance in Maven) */
  private PaymentProcessor paymentProcessor;

  @Inject
  public Main(PaymentProcessor paymentProcessor) {
    this.paymentProcessor = paymentProcessor;
  }

  //Otherwise, you can use the following main method
  public static void main(String[] args) {
    Weld weld = new Weld();
    try (WeldContainer weldContainer = weld.initialize()) {
      log.info(weldContainer.select(PaymentProcessor.class).get().processPayment());
    }

  }
  /* End of the part that works only if Weld (CDI engine is already started for instancein Maven) */

  public void startup(@Observes ContainerInitialized event) {
    log.info(paymentProcessor.processPayment());
  }

}
