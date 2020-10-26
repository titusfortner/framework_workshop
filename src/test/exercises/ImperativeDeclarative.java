package test.exercises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.data.Product;
import test.pages.CartPage;
import test.pages.InventoryPage;
import test.pages.ProductPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//
// Exercise:
// rewrite this test to be declarative in the method below
//
// (necessary methods are already implemented in the Page Objects)
//

public class ImperativeDeclarative {
    WebDriver driver;

    @Before
    public void setup() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");
        }

        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void imperative() {
        driver.get("https://www.saucedemo.com/inventory.html");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getInventoryItem("Sauce Labs Bike Light").click();

        ProductPage productPage = new ProductPage(driver);
        productPage.getAddToCartButton().click();
        productPage.getCartButton().click();

        CartPage cartPage = new CartPage(driver);
        assertEquals("Sauce Labs Bike Light", cartPage.getItemName());
    }

    @Test
    public void declarative() {
        Product product = Product.valid();

        InventoryPage inventoryPage = InventoryPage.visit(driver);
        inventoryPage.selectProduct(product);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.checkout();

        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.hasProduct(product));
    }
}

