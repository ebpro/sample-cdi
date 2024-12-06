package fr.univtln.bruno.samples.cdi;

import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class EntryPointSingleton {

  private PaymentProcessor paymentProcessor;

  public EntryPointSingleton() {
  }

  @Inject
  public EntryPointSingleton(PaymentProcessor paymentProcessor) {
    this.paymentProcessor = paymentProcessor;
  }

  public void onStart(@Observes @Initialized(Singleton.class) Object object) {
    log.info("Container initialized, starting payment processing...");
    log.info("-ENTRYPOINT SINGLETON-> {}", paymentProcessor.processPayment());
  }
}
