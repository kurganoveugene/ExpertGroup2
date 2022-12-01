package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public final class WaitUtil {
    private static final int TIMEOUT_SECONDS;

    private WaitUtil() {
    }

    static {
        TIMEOUT_SECONDS = DriverProperties.getInstance().getExplicitWait();
    }

    public static <T> void wait(Function<? super WebDriver, T> isTrue) {
        getWebDriverWait().until(isTrue);
    }

    public static Alert waitAlert() {
        return getWebDriverWait().until(ExpectedConditions.alertIsPresent());
    }

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(WebDriverInstanceManager.getDriver(), Duration.ofMillis(TIMEOUT_SECONDS));
    }
}
