package fr.univtln.bruno.samples.restapi;

import fr.univtln.bruno.samples.cdi.PaymentProcessor;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

/**
 * PaymentResource is a RESTful resource class that handles payment processing requests.
 * It uses CDI (Contexts and Dependency Injection) to inject a PaymentProcessor instance.
 *
 * <p>This class is annotated with:
 * <ul>
 *   <li>{@code @Slf4j} - for logging purposes using the SLF4J API.</li>
 *   <li>{@code @Path("/payment")} - to define the base URI for all resource URIs provided by this class.</li>
 *   <li>{@code @RequestScoped} - to specify that a new instance of this class will be created for each HTTP request.</li>
 * </ul>
 *
 * <p>Methods:
 * <ul>
 *   <li>{@code test()} - a POST method that processes a payment request and returns the result as a String.</li>
 * </ul>
 *
 * <p>Dependencies:
 * <ul>
 *   <li>{@code PaymentProcessor} - a service class that handles the actual payment processing logic.</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>
 * {@code
 * POST /payment
 * }
 * </pre>
 *
 * <p>Logging:
 * <ul>
 *   <li>Logs an info message when a payment is being processed.</li>
 * </ul>
 *
 * <p>Note: This is a sample implementation for educational purposes.
 */
@Slf4j
@Path("/payment")
@RequestScoped
public class PaymentResource {

  private PaymentProcessor paymentProcessor;

  public PaymentResource() {
  }

  @Inject
  public PaymentResource(PaymentProcessor paymentProcessor) {
    this.paymentProcessor = paymentProcessor;
  }

  @POST
  public String test() {
    log.info("Processing payment throut REST API...");
    return paymentProcessor.processPayment();
  }

}
