package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressSignInPage extends BasePage {

    private By email = By.id("session_email");

    public static AddressSignInPage visit(WebDriver driver) {
        driver.get("http://a.testaddressbook.com/");
        driver.findElement(By.id("sign-in")).click();
        return new AddressSignInPage(driver);
    }

    public AddressSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillEmail(String name) {
        sendKeys(email, name);
    }
}
