package test.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.pages.AddressSignInPage;

public class AbstractWaits {
    protected WebDriver driver;

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
    public void teardown() {
        driver.quit();
    }

    @Test
    public void abstractWaits() throws InterruptedException {
        AddressSignInPage addressSignInPage = AddressSignInPage.visit(driver);
        addressSignInPage.fillEmail("name@example.com");
        Thread.sleep(5000);
    }
}
