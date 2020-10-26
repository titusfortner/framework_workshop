package test.exercises;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

//
// Exercise:
// Get Test to pass by starting ChromeDriver with mobile emulation
//
// https://chromedriver.chromium.org/mobile-emulation
//

public class ChromeOptionsMobileEmulation {
    WebDriver driver;

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void mobileEmulation() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");
        }

        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver(chromeOptions);

        driver.navigate().to("https://google.com");

        assertTrue(driver.findElement(By.cssSelector("a[data-bucket=mobilehp]")) != null);
    }

}
