package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Utility class for reading configuration properties from a properties file.

public class ConfigReaderUtil {

    // Path to the properties file containing configuration settings
    private static final String PROP_FILE_PATH = "src/test/resources/config/Config.properties";

    /**
     * Loads properties from the configuration file.
     */
    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(PROP_FILE_PATH)) {
            properties.load(input);
        } catch (IOException e) {
            // Print error details and throw a runtime exception if file loading fails
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file");
        }
        return properties;
    }

    // Retrieves a property value based on the provided key.

    public static String getProperty(String key) {
        return loadProperties().getProperty(key);
    }
}
