package utils.locator;

import org.openqa.selenium.By;

public class ElementLocator {
    public static By getBy(ElementType type, String value) {
        return switch (type) {
            case ID -> By.id(value);
            case XPATH -> By.xpath(value);
            case CLASS_NAME -> By.className(value);
            case CSS_SELECTOR -> By.cssSelector(value);
            case NAME -> By.name(value);
            default -> throw new IllegalArgumentException("Invalid locator type: " + type);
        };
    }
}
