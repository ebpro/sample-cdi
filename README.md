# Simple Sample CDI Project

## Overview

This project is a sample application demonstrating the use of Contexts and Dependency Injection (CDI) in Java. It includes various examples of CDI concepts such as qualifiers, producers, and dependency injection. Additionally, it presents interceptors and decorators.

## Warning

For Jakarta EE in a real app, you need to remove the following dependency from the `pom.xml` file:

    ```xml
    <dependency>
      <groupId>org.jboss.weld.se</groupId>
      <artifactId>weld-se-core</artifactId>
    </dependency>
    ```

It is only needed for Java SE.
  
## Objective

The objective of this project is to demonstrate how to use CDI in Java applications. It includes examples of how to use qualifiers, producers, interceptors, and decorators. The project can be used as a JakartaEE application or as a standalone application.

The easiest entry point is the [`Main`](src/main/java/fr/univtln/bruno/samples/cdi/Main.java) class used for Java SE.

- The main class uses an instance of `PaymentProcessor` to process payments. The implementation of `PaymentProcessor` is injected using CDI, and no specific implementation is provided in the code. In this project, the `PaymentProcessor` uses a [`PaymentService`](src/main/java/fr/univtln/bruno/samples/cdi/PaymentService.java) (an interface) which is injected using CDI. There are three implementations of `PaymentService` in this project:

  - [`CreditCardPaymentServiceImpl`](src/main/java/fr/univtln/bruno/samples/cdi/services/implantations/CreditCardPaymentServiceImpl.java)
  - [`PayPalPaymentRestServiceImpl`](src/main/java/fr/univtln/bruno/samples/cdi/services/implantations/PayPalPaymentRestServiceImpl.java)
  - [`PayPalPaymentWebsocketServiceImpl`](src/main/java/fr/univtln/bruno/samples/cdi/services/implantations/PayPalPaymentWebsocketServiceImpl.java)

To choose the implementation of `PaymentService` to use, you can use the [`CreditCard`](src/main/java/fr/univtln/bruno/samples/cdi/qualifiers/CreditCard.java), [`PayPal`](src/main/java/fr/univtln/bruno/samples/cdi/qualifiers/PayPal.java), [`Rest`](src/main/java/fr/univtln/bruno/samples/cdi/qualifiers/Rest.java), and [`Websocket`](src/main/java/fr/univtln/bruno/samples/cdi/qualifiers/Websocket.java) qualifiers.

In this sample, a `PayPal` implementation is chosen declaratively in the `PaymentProcessor` class. To change the implementation, you can change the qualifier in the `PaymentProcessor` class. As there are two implementations annotated with `PayPal`, one of them (`PayPalPaymentWebsocketServiceImpl`) is annotated with `@Alternative`. By default, the `PayPalPaymentRestServiceImpl` is used. To use the `PayPalPaymentWebsocketServiceImpl`, you can edit the `beans.xml` file and add the `alternatives` tag with the `PayPalPaymentWebsocketServiceImpl` class name.

## Interceptors and Decorators

To add functionality to the payment processing without changing the implementation, this project includes interceptors and decorators.

An interceptor is a class that intercepts the invocation of a method. It can be used to add functionality to a method without modifying the method itself. In this project, the [`PaymentInterceptor`](src/main/java/fr/univtln/bruno/samples/cdi/PaymentInterceptor.java) class is used to log payment transactions.

A decorator is a class that adds functionality to a bean. It can be used to add functionality to a bean without modifying the bean itself. In this project, the [`PaymentDecorator`](src/main/java/fr/univtln/bruno/samples/cdi/PaymentDecorator.java) class is used to add a discount to payment transactions.

### Producers

Producers are used to create instances of beans or to provide values for injection points. They can be used to create beans that are not managed by the CDI container or to provide values that are not available at compile time. In this project, producers are used to create instances of the `MaxAmount` and `MinAmount` classes, which are used to set the maximum and minimum amounts for payment transactions.

- [`MaxAmount`](src/main/java/fr/univtln/bruno/samples/cdi/producers/MaxAmount.java) is a producer method.
- [`MinAmount`](src/main/java/fr/univtln/bruno/samples/cdi/producers/MinAmount.java) is a producer field.

## Building and Running the Project

### Java SE

To build the project and run all tests, use the following commands:

To build a shaded JAR, use:

```bash
./mvnw clean package
```

To run the application, use the following command:

```sh
./mvnw package exec:java -Dexec.mainClass="fr.univtln.bruno.samples.cdi.Main"
```

### JakartaEE

### Integration with Rest Ressources

- The project includes a REST resource that can be used to process payments. The [`PaymentResource`](src/main/java/fr/univtln/bruno/samples/cdi/resources/PaymentResource.java) class is a JAX-RS resource that can be used to process payments using the `PaymentProcessor` class. The `PaymentProcessor` is injected in the `PaymentResource` class to process payments.

#### Payara Micro (with Maven Plugin)

The payara micro maven plugin build the War file and bundle it in a jar withg a payara micro distribution.
The JakartaEE server and the application are in a single jar.

```sh
./mvnw -P payaramicro clean install payara-micro:bundle
java -jar target/sample-cdi-0.1.0-SNAPSHOT-microbundle.jar
```

```sh
curl -X POST http://localhost:8080/sample-cdi-0.1.0-SNAPSHOT/api/v1/payment
```

#### Payara Micro in a Container

The `Dockerfile` is provided to build the application in a first stage and add it to a payara micro base image.

```sh
docker build --tag brunoe/sample-cdi .
docker run -p 8080:8080 brunoe/sample-cdi

```sh
curl -X POST http://localhost:8080/sample-cdi-0.1.0-SNAPSHOT/api/v1/payment
```
