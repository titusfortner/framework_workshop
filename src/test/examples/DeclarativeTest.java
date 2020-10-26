package test.examples;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.pages.HomePage;
import test.pages.InventoryPage;
import test.data.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeclarativeTest {
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
    public void declarative() {
        HomePage homePage = HomePage.visit(driver);

        homePage.signIn(User.valid());

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.onPage());
    }

}
