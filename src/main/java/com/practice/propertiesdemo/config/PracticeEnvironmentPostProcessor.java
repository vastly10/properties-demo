package com.practice.propertiesdemo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;

public class PracticeEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String location = environment.getProperty("practice.properties.location");
        ClassPathResource resource = new ClassPathResource(location);
        if(!resource.exists()) {
            throw new IllegalArgumentException("properties file does not exist");
        }
        try {
            environment.getPropertySources().addLast(new PropertiesPropertySource("practice-properties", PropertiesLoaderUtils.loadProperties(resource)));
        } catch (IOException e) {
            throw new IllegalStateException("failed to load from path " + location, e);
        }
    }
}
