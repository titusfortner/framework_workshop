package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.data.User;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static String url = "https://www.saucedemo.com/";

    public static HomePage visit(WebDriver driver) {
        driver.get(url);
        return new HomePage(driver);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmit() {
        return driver.findElement(By.className("btn_action"));
    }

    public void signInSuccessfully(User user) throws Exception {
        try {
            signIn(user);
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
        } catch (TimeoutException e) {
            throw new Exception("Sign In Unsuccessful");
        }
    }

    public void signIn(User user) {
        getUsername().sendKeys(user.getUsername());
        getPassword().sendKeys(user.getPassword());
        getSubmit().click();
    }

}
