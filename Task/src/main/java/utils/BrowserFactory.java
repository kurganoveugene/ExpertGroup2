package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BrowserFactory {
    private static final Logger logger = LoggerFactory.getLogger(BrowserFactory.class);

    public static WebDriver getWebDriverForBrowser(String browserName) {
        return getWebDriverForBrowser(Browser.valueOf(browserName.toUpperCase()));
    }

    public static WebDriver getWebDriverForBrowser(Browser browser) {
        WebDriver webDriver = switch (browser) {
            case CHROME -> getChromeWD();
            case FIREFOX -> getFirefoxWD();
            case EDGE -> getEdgeWD();
        };
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(DriverProperties.getInstance().getImplicitlyWait()));
        return webDriver;
    }

    private static EdgeDriver getEdgeWD() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments(getScreenSizeArgument());
        logger.info("Created web driver for Edge browser");
        return new EdgeDriver(options);
    }

    private static FirefoxDriver getFirefoxWD() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(getScreenSizeArgument());
        logger.info("Created web driver for Firefox browser");
        return new FirefoxDriver(options);
    }

    private static ChromeDriver getChromeWD() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(getScreenSizeArgument());
        logger.info("Created web driver for Chrome browser");
        return new ChromeDriver(options);
    }

    private static String getScreenSizeArgument() {
        String windowSize = DriverProperties.getInstance().getWindowSize();
        final String resultArgument;
        if ("maximized".equalsIgnoreCase(windowSize))
            resultArgument = "--start-maximized";
        else
            resultArgument = "window-size=" + windowSize;
        return resultArgument;
    }

    public enum Browser {
        CHROME, FIREFOX, EDGE
    }
}
