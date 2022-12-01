package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static testframework.utils.WebDriverInstanceManager.getDriver;

public final class DriverUtil {
    private static final Logger logger = LoggerFactory.getLogger(DriverUtil.class);

    private DriverUtil() {
    }

    public static WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public static boolean isInDom(By by) {
        return !getDriver().findElements(by).isEmpty();
    }

    public static void quitDriver() {
        WebDriverInstanceManager.quitDriver();
    }

    public static void get(String url) {
        logger.info("Following a link: " + url);
        getDriver().get(url);
    }

    public static boolean isAlertDisplayed() {
        try {
            logger.info("Check alert displayed");
            getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void switchToFrame(By frameLocator) {
        WaitUtil.wait(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public static void toDefaultContent() {
        logger.info("Switch to default content frame");
        getDriver().switchTo().defaultContent();
    }

    public static String getUrl() {
        return getDriver().getCurrentUrl();
    }

    public static String switchToAnotherTab() {
        logger.info("Switch to another tab");
        String windowHandle = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            if (!handle.equals(windowHandle)) {
                getDriver().switchTo().window(handle);
                return windowHandle;
            }
        }
        throw new RuntimeException("The browser has one open tab");
    }

    public static void closeCurrentTab() {
        logger.info("Close current tab");
        getDriver().close();
    }

    public static void switchToTab(String windowHandle) {
        logger.info("Switch to tab by windows handle");
        getDriver().switchTo().window(windowHandle);
    }
}
