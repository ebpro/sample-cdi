package fr.univtln.bruno.samples.cdi.services.implantations;

import fr.univtln.bruno.samples.cdi.qualifiers.PayPal;
import fr.univtln.bruno.samples.cdi.qualifiers.Rest;
import fr.univtln.bruno.samples.cdi.services.PaymentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of the PaymentService interface for processing payments via PayPal REST API.
 * This service is annotated with @PayPal, @Rest, and @Dependent to indicate its specific 
 * configuration and scope within the CDI (Contexts and Dependency Injection) framework.
 * 
 * The class uses Lombok's @Slf4j for logging purposes.
 * 
 * Methods:
 * - processPayment(): Processes the payment using PayPal REST API.
 * - initialize(): Initializes the service, called after the bean's construction.
 * - cleanup(): Cleans up resources before the bean is destroyed.
 * 
 * Annotations:
 * - @PayPal: Custom annotation to mark this service as a PayPal payment service.
 * - @Rest: Custom annotation to mark this service as a RESTful service.
 * - @Dependent: CDI scope annotation indicating that this bean's lifecycle is dependent on the client.
 * - @Slf4j: Lombok annotation to generate a logger instance.
 * - @PostConstruct: Marks the initialize method to be called after the bean's construction.
 * - @PreDestroy: Marks the cleanup method to be called before the bean's destruction.
 */
@PayPal
@Rest
@Dependent
@Slf4j
public class PayPalPaymentRestServiceImpl implements PaymentService {
    @Override
    public String processPayment() {
        log.info("{}", "Traitement du paiement via PayPal REST API");
        return "PayPal REST API"; 
    }

    @PostConstruct
    public void initialize() {
        log.info("Initializing PayPalPaymentRestServiceImpl");
    }

    @PreDestroy
    public void cleanup() {
        log.info("Cleaning up PayPalPaymentRestServiceImpl");
    }
}