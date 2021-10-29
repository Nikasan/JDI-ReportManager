package hw8.Utils;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class SetUpDriver {
    public static RemoteWebDriver CreateWebDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("screenResolution", "1920x1080x24");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "89.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("http://selenoid-uri:4444/wd/hub").toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        return driver;
    }
}