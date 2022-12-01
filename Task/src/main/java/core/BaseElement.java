package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testframework.utils.DriverUtil;
import testframework.utils.WaitUtil;

public abstract class BaseElement {
    private static final Logger logger = LoggerFactory.getLogger(BaseElement.class);
    private final By locator;
    private final String name;

    protected BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void click() {
        logger.info("Click on " + name + " element");
        WebElement element = findElement();
        element.click();
    }

    protected WebElement findElement() {
        logger.info("Find element: " + name);
        try {
            return DriverUtil.findElement(locator);
        } catch (NoSuchElementException e) {
            logger.error("Web element " + name + " not found", e);
            throw e;
        }
    }

    public boolean isDisplayed() {
        logger.info("Checking the display of element " + name);
        return DriverUtil.isInDom(locator);
    }

    protected String getName() {
        return name;
    }

    public String getText() {
        WebElement element = findElement();
        logger.info("Get text from element " + name);
        return element.getText();
    }

    public void waitToDisplay() {
        logger.info("Wait to display element " + name);
        WaitUtil.wait(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitToHide() {
        logger.info("Wait to hide element " + name);
        WaitUtil.wait(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitClickable() {
        logger.info("Wait to clickable element " + name);
        WaitUtil.wait(ExpectedConditions.elementToBeClickable(locator));
    }
}
