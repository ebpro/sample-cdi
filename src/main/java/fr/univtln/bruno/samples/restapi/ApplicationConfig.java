package fr.univtln.bruno.samples.restapi;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

/**
 * ApplicationConfig class extends the javax.ws.rs.core.Application class to configure
 * the JAX-RS application. It sets the base URI path for the REST API and configures
 * properties for the application.
 * 
 * <p>The @ApplicationPath annotation specifies the base URI path for all JAX-RS
 * resources in the application. In this case, the base path is "/api/v1".</p>
 * 
 * <p>The getProperties method overrides the default implementation to provide
 * custom properties for the JAX-RS application. Here, it configures the Jersey
 * JSON feature to use Jackson for JSON processing.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @ApplicationPath("/api/v1")
 * public class ApplicationConfig extends Application {
 *     @Override
 *     public Map<String, Object> getProperties() {
 *         Map<String, Object> props = new HashMap<>();
 *         props.put("jersey.config.jsonFeature", "JacksonFeature");
 *         return props;
 *     }
 * }
 * }
 * </pre>
 * 
 * <p>Students can use this class as a template for configuring their own JAX-RS
 * applications, customizing the base URI path and properties as needed.</p>
 */
@ApplicationPath("/api/v1")
public class ApplicationConfig extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("jersey.config.jsonFeature", "JacksonFeature");
        return props;
    }
    
}
