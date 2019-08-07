package com.opencart.allure;

import com.opencart.environment.EnvironmentConstants;
import com.opencart.environment.PropertiesController;

import java.util.Properties;

public class AllureEnvironmentController {

    public void createPropertyFile() {
        Properties environmentProperties = PropertiesController.loadProperties(EnvironmentConstants.INPUT_ENVIRONMENT_PROPERTIES_PATH);
        PropertiesController.createPropertyFile(EnvironmentConstants.OUTPUT_ENVIRONMENT_PROPERTIES_PATH, environmentProperties);
    }

}
