package com.opencart.environment;

import java.util.Properties;

public class EnvironmentConstants {

    private static final Properties MAIN_RESOURCES_PROPERTIES = PropertiesController
            .loadProperties("src/main/resources/resources.properties");
    public static final String INPUT_ENVIRONMENT_PROPERTIES_PATH
            = MAIN_RESOURCES_PROPERTIES.getProperty("INPUT_ENVIRONMENT_PROPERTIES_PATH");
    public static final String OUTPUT_ENVIRONMENT_PROPERTIES_PATH
            = MAIN_RESOURCES_PROPERTIES.getProperty("OUTPUT_ENVIRONMENT_PROPERTIES_PATH");

    private static final Properties ENVIRONMENT_PROPERTIES = PropertiesController
            .loadProperties(MAIN_RESOURCES_PROPERTIES.getProperty("INPUT_ENVIRONMENT_PROPERTIES_PATH"));
    public static final String BASE_URL = ENVIRONMENT_PROPERTIES.getProperty("BASE_URL");
    public static final String PORT = ENVIRONMENT_PROPERTIES.getProperty("PORT");

    private static final Properties CREDENTIALS_PROPERTIES = PropertiesController
            .loadProperties("src/main/resources/api_credentials.properties");
    public static final String API_USER_NAME = CREDENTIALS_PROPERTIES.getProperty("API_USER_NAME");
    public static final String API_KEY = CREDENTIALS_PROPERTIES.getProperty("API_KEY");

    private EnvironmentConstants() {
    }

}
