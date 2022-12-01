package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertUtil {
    private static final Logger logger = LoggerFactory.getLogger(AlertUtil.class);

    public static String getAlertText() {
        logger.info("Getting text from an alert");
        return WaitUtil.waitAlert().getText();
    }

    public static void clickOk() {
        logger.info("Click on Ok button in an alert");
        WaitUtil.waitAlert().accept();
    }

    public static void enterText(String text) {
        logger.info("Send text: " + text + " into alert");
        WaitUtil.waitAlert().sendKeys(text);
    }
}
