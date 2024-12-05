package fr.univtln.bruno.samples.cdi.services;

/**
 * The PaymentService interface provides a contract for processing payments.
 * Implementations of this interface should define the specific logic for processing a payment.
 */
public interface PaymentService {
    String processPayment();
}