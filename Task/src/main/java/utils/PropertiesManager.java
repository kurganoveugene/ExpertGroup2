package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesManager {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesManager.class);

    public static Properties getProperties(String filePath) {
        logger.info("Read properties file by path: " + filePath);
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream(filePath)) {
            properties.load(new InputStreamReader(is, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Properties file not found");
        }
        return properties;
    }
}
