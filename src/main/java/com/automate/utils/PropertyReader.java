package com.automate.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final Properties properties = new Properties();

    public PropertyReader() {
        loadAllProperties();
    }

    // Load properties file
    private void loadAllProperties() {
        try (FileInputStream fis = new FileInputStream("src/main/resources/akodev_config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file: " + e.getMessage(), e);
        }
    }

    public static String readItem(String propertyName) {
        return properties.getProperty(propertyName, "Property not found: " + propertyName);
    }
}

