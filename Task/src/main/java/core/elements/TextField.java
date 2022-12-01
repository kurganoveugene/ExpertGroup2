package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testframework.core.BaseElement;

public class TextField extends BaseElement {
    private static final Logger logger = LoggerFactory.getLogger(TextField.class);

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void setText(String text) {
        WebElement element = findElement();
        logger.info("Send text to element " + getName());
        element.sendKeys(text);
    }
}
