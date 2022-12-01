package utils;

import java.util.Properties;

public class DriverProperties {
    private static final DriverProperties DRIVER_PROPERTIES = new DriverProperties();

    static DriverProperties getInstance() {
        return DRIVER_PROPERTIES;
    }

    private final Properties properties;

    private DriverProperties() {
        properties = PropertiesManager.getProperties("driver.properties");
    }

    public String getWindowSize() {
        return properties.get("window-size").toString();
    }

    public String getBrowser() {
        return properties.get("browser").toString();
    }

    public int getImplicitlyWait() {
        return Integer.parseInt(properties.get("implicitly.wait.millis").toString());
    }

    public int getExplicitWait() {
        return Integer.parseInt(properties.get("explicit.wait.millis").toString());
    }
}
