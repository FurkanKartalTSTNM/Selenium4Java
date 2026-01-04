package com.testinium.selenium4javakartal.baseTest;

import com.testinium.driver.TestiniumSeleniumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest implements BeforeAllCallback, AfterAllCallback {

    protected RemoteWebDriver driver;

    @Override
    public void beforeAll(ExtensionContext context) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        String remoteUrl = System.getenv().getOrDefault(
                "SELENIUM_REMOTE_URL",
                "http://host.docker.internal:4444/wd/hub"
        );

        driver = new TestiniumSeleniumDriver(new URL(remoteUrl), options);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        if (driver != null) {
            driver.quit();
        }
    }
}
