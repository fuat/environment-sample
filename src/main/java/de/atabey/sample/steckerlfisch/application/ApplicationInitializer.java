package de.atabey.sample.steckerlfisch.application;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import java.io.IOException;

/**
 * @author Fuat Atabey
 */
public class ApplicationInitializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

    @Override
    public void initialize(ConfigurableWebApplicationContext configurableWebApplicationContext) {
        configurableWebApplicationContext.getEnvironment().setActiveProfiles("embeddedDB", "mock");
        final ResourcePropertySource propertySource;
        try {
            propertySource = new ResourcePropertySource("classpath:/environment/environment.properties");
            configurableWebApplicationContext.getEnvironment().getPropertySources().addLast(propertySource);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
