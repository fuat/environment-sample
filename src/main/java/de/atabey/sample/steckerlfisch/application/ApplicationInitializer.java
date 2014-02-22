package de.atabey.sample.steckerlfisch.application;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * @author Fuat Atabey
 */
public class ApplicationInitializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

    @Override
    public void initialize(ConfigurableWebApplicationContext configurableWebApplicationContext) {
        configurableWebApplicationContext.getEnvironment().setActiveProfiles("embeddedDB", "mock");
    }
}
