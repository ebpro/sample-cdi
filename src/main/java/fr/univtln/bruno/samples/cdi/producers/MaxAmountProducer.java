package fr.univtln.bruno.samples.cdi.producers;

import java.util.Random;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

/**
 * This class is a CDI producer that generates random amounts.
 * It is annotated with {@link ApplicationScoped} to indicate that it is a singleton within the CDI container.
 * 
 * The {@code produceRandomNumber} method produces a random integer between 0 and 99, inclusive.
 * It is annotated with {@link Produces} and {@link MaxAmount} to indicate that it produces a maximum amount.
 * 
 * The {@code minAmount} field is a producer field that provides a minimum amount of 1.
 * It is annotated with {@link Produces} and {@link MinAmount}.
 * 
 * Annotations used:
 * - {@link ApplicationScoped}: Indicates that the bean is application-scoped.
 * - {@link Produces}: Indicates that the method or field is a producer.
 * - {@link MaxAmount}: Custom qualifier for maximum amount.
 * - {@link MinAmount}: Custom qualifier for minimum amount.
 */
@ApplicationScoped
public class MaxAmountProducer {
    private Random random = new Random();

    @Produces
    @MaxAmount
    public int produceRandomNumber() {
        return random.nextInt(100); // Retourne un entier aléatoire entre 0 et 99
    }

    @Produces
    @MinAmount
    private int minAmount=1;
}