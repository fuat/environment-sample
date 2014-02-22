package de.atabey.sample.steckerlfisch.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Fuat Atabey
 */
public class ApplicationInitializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

    private Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);
    @Override
    public void initialize(ConfigurableWebApplicationContext configurableWebApplicationContext) {
        final ConfigurableEnvironment environment = configurableWebApplicationContext.getEnvironment();
        addPropertySourceIfExistsToEnvironment(environment, "file:/etc/context-name.properties");
        addPropertySourceIfExistsToEnvironment(environment, "classpath:/environment/environment.properties");
        addPropertySourceIfExistsToEnvironment(environment, "classpath:/environment/" + getHostName() + ".properties");
        addPropertySourceIfExistsToEnvironment(environment,
                environment.resolveRequiredPlaceholders("classpath:/environment/${deployment.context}.properties"));
    }

    private void addPropertySourceIfExistsToEnvironment(ConfigurableEnvironment environment, String location) {
        try {
            environment.getPropertySources().addLast(new ResourcePropertySource(location));
            logger.info("PropertyResource from location {} added.", location);
        } catch (IOException e) {
            logger.debug("Resource at location {} not found", location);
        }
    }


    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "UNKNOWN";
        }
    }
}
