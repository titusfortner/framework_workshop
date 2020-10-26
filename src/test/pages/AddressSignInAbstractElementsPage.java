package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressSignInAbstractElementsPage extends BaseElementAbstractionPage {

    private By email = By.id("session_email");

    public static AddressSignInAbstractElementsPage visit(WebDriver driver) {
        driver.get("http://a.testaddressbook.com/");
        driver.findElement(By.id("sign-in")).click();
        return new AddressSignInAbstractElementsPage(driver);
    }

    public AddressSignInAbstractElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillEmail(String name) {
        getElement(email).sendKeys(name);
    }
}
