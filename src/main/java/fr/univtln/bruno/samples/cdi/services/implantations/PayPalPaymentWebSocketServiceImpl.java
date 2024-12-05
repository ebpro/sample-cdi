package fr.univtln.bruno.samples.cdi.services.implantations;

import fr.univtln.bruno.samples.cdi.qualifiers.PayPal;
import fr.univtln.bruno.samples.cdi.qualifiers.Websocket;
import fr.univtln.bruno.samples.cdi.services.PaymentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of the PaymentService interface for processing payments via PayPal WebSocket API.
 * 
 * <p>This class is annotated with {@code @PayPal}, {@code @Websocket}, and {@code @Alternative} 
 * to indicate that it is an alternative implementation of a payment service using PayPal and WebSocket.
 * It is also annotated with {@code @Dependent} to specify its scope and {@code @Slf4j} for logging purposes.</p>
 * 
 * <p>The {@code processPayment} method logs the payment processing action. The {@code initialize} method 
 * is annotated with {@code @PostConstruct} to perform initialization tasks, and the {@code cleanup} method 
 * is annotated with {@code @PreDestroy} to perform cleanup tasks before the bean is destroyed.</p>
 * 
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * PayPalPaymentWebSocketServiceImpl service = new PayPalPaymentWebSocketServiceImpl();
 * service.processPayment();
 * }
 * </pre>
 * 
 * @see PaymentService
 * @see javax.annotation.PostConstruct
 * @see javax.annotation.PreDestroy
 */
@PayPal
@Websocket
@Alternative

@Dependent
@Slf4j
public class PayPalPaymentWebSocketServiceImpl implements PaymentService {
    @Override
    public String processPayment() {
        log.info("{}", "Traitement du paiement via PayPal Websocket API");       
        return "PayPal Websocket API"; 
    }

    @PostConstruct
    public void initialize() {
        log.info("Initializing PayPalPaymentWebSocketServiceImpl");
    }

    @PreDestroy
    public void cleanup() {
        log.info("Cleaning PayPalPaymentWebSocketServiceImpl");
    }
}