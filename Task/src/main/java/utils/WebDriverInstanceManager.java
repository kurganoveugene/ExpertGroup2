package utils;

import org.openqa.selenium.WebDriver;

public final class WebDriverInstanceManager {
    private static WebDriver driver;
    private final static String BROWSER;

    private WebDriverInstanceManager() {
    }

    static {
        BROWSER = DriverProperties.getInstance().getBrowser();
    }

    static void initDriver() {
        driver = BrowserFactory.getWebDriverForBrowser(BROWSER);
    }

    static WebDriver getDriver() {
        if (driver == null)
            initDriver();
        return driver;
    }

    static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
