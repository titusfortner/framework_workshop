package test.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Waits {
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
    public void noWait() {
        driver.get("http://a.testaddressbook.com/");
        driver.findElement(By.id("sign-in")).click();

        driver.findElement(By.id("session_email"));
    }

    @Test
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://a.testaddressbook.com/");
        driver.findElement(By.id("sign-in")).click();

        driver.findElement(By.id("session_email"));
    }

    @Test
    public void sleep() throws InterruptedException {
        driver.get("http://a.testaddressbook.com/");

        Thread.sleep(2000);
        driver.findElement(By.id("sign-in")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("session_email"));
    }

    @Test
    public void fluentWait() {
        driver.get("http://a.testaddressbook.com/");
        driver.findElement(By.id("sign-in")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        WebElement email = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("session_email"));
            }
        });
    }

    @Test
    public void explicitWait() {
        driver.get("http://a.testaddressbook.com/");
        WebDriverWait explicitWait = new WebDriverWait(driver, 20);

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("sign-in")));
        driver.findElement(By.id("sign-in")).click();

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("session_email")));
        driver.findElement(By.id("session_email"));
    }
}
