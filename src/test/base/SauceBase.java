package test.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SauceBase {
    protected WebDriver driver;
    private String defaultPlatform = "windows_7_firefox";

    private MutableCapabilities getCapabilities() throws FileNotFoundException {
        Map<String, Object> platform = getPlatform(System.getProperty("PLATFORM_NAME"));
        MutableCapabilities capabilities = new MutableCapabilities();

        for (Map.Entry<String, Object> data : platform.entrySet()) {
            capabilities.setCapability(data.getKey(), data.getValue());
        }

        return capabilities;
    }

    public Map<String, Object> getPlatform(String platform) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream file = new FileInputStream("src/test/config/platforms.yml");
        Object platformData = yaml.load(file);
        Map<String, Object> platforms = (Map<String, Object>) platformData;

        return (Map<String, Object>) platforms.get(platform);
    }

    public String getBuild() {
        if (System.getenv("BUILD_TAG") != null) {
            return System.getenv("BUILD_TAG");
        } else {
            return "Local Build - " + System.currentTimeMillis();
        }
    }

    @Rule
    public TestName name = new TestName();

    @Before
    public void setup() throws MalformedURLException, FileNotFoundException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("name", name.getMethodName());
        sauceOptions.setCapability("build", getBuild());
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));

        MutableCapabilities capabilities = getCapabilities();
        capabilities.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, capabilities);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
