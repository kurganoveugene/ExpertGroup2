package core;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testframework.utils.DriverUtil;

public abstract class Frame extends BaseForm {
    private static final Logger logger = LoggerFactory.getLogger(Frame.class);
    private final By frameLocator;

    public Frame(String name, BaseElement uniqueElement, By frameLocator) {
        super(name, uniqueElement);
        this.frameLocator = frameLocator;
    }

    public void switchTo() {
        logger.info("Switch to frame: " + getName());
        DriverUtil.switchToFrame(frameLocator);
    }

    public void exitFrame() {
        DriverUtil.toDefaultContent();
    }
}
