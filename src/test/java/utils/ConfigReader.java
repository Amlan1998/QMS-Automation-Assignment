package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties props = new Properties();

    static {
        try {
            FileInputStream fis =
                new FileInputStream("src/test/resources/config/properties/config.properties");
            props.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
