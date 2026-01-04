package com.testinium.selenium4javakartal.baseTest;

import com.testinium.driver.TestiniumSeleniumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    protected RemoteWebDriver driver;

    @BeforeAll
    void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        String remoteUrl = System.getenv().getOrDefault(
                "SELENIUM_REMOTE_URL",
                "http://host.docker.internal:4444/wd/hub"
        );

        driver = new TestiniumSeleniumDriver(new URL(remoteUrl), options);
    }

    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
