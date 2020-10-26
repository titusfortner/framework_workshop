package test.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.pages.HomePage;

import static org.junit.Assert.assertEquals;

public class ImperativeTest {

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
        driver.get("https://www.saucedemo.com/");

        HomePage homePage = new HomePage(driver);
        homePage.getUsername().sendKeys("standard_user");
        homePage.getPassword().sendKeys("secret_sauce");
        homePage.getSubmit().click();

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        assertEquals(expectedURL, driver.getCurrentUrl());
    }

}
