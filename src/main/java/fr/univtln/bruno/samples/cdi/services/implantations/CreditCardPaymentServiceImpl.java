package fr.univtln.bruno.samples.cdi.services.implantations;

import fr.univtln.bruno.samples.cdi.qualifiers.CreditCard;
import fr.univtln.bruno.samples.cdi.services.PaymentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of the PaymentService interface for processing credit card
 * payments.
 * 
 * <p>
 * This class is annotated with {@code @CreditCard} and {@code @Dependent},
 * indicating
 * that it is a CDI (Contexts and Dependency Injection) bean with a dependent
 * scope.
 * </p>
 * 
 * <p>
 * It provides the following functionalities:
 * </p>
 * <ul>
 * <li>{@code processPayment()}: Processes the payment using a credit card.</li>
 * <li>{@code initialize()}: Initializes the service, annotated with
 * {@code @PostConstruct}
 * to indicate that this method should be called after the bean's
 * construction.</li>
 * <li>{@code cleanup()}: Cleans up resources, annotated with
 * {@code @PreDestroy} to indicate
 * that this method should be called before the bean's destruction.</li>
 * </ul>
 */
@CreditCard
@Dependent
@Slf4j
public class CreditCardPaymentServiceImpl implements PaymentService {
    @Override
    public String processPayment() {        
        log.info("Traitement du paiement par carte de crédit");
        return "Carte de crédit";
    }

    @PostConstruct
    public void initialize() {
        log.info("Initializing CreditCardPaymentServiceImpl");
    }

    @PreDestroy
    public void cleanup() {
        log.info("Cleaning up CreditCardPaymentServiceImpl");
    }
}