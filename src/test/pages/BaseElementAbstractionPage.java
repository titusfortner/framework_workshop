package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.elements.Element;

class BaseElementAbstractionPage {
    WebDriver driver;

    Element getElement(By locator) {
        return new Element(driver, locator);
    }
}
