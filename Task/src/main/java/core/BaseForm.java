package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseForm {
    private static final Logger logger = LoggerFactory.getLogger(BaseForm.class);
    private final String name;
    private final BaseElement uniqueElement;

    protected BaseForm(String name, BaseElement uniqueElement) {
        this.name = name;
        this.uniqueElement = uniqueElement;
    }

    public boolean isDisplayed() {
        logger.info("Checking the display of form " + name);
        return uniqueElement.isDisplayed();
    }

    protected String getName() {
        return name;
    }

    protected BaseElement getUniqueElement() {
        return uniqueElement;
    }
}
