package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.className("btn_inventory"));
    }

    public WebElement getCartButton() {
        return driver.findElement(By.className("shopping_cart_link"));
    }

    public ProductPage addToCart() {
        getAddToCartButton().click();
        return this;
    }

    public CartPage checkout() {
        getCartButton().click();
        return new CartPage(driver);
    }
}
