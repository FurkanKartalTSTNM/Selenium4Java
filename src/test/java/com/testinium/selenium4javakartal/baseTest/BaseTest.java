package com.testinium.selenium4javakartal.baseTest;

import com.testinium.driver.TestiniumSeleniumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {

    protected RemoteWebDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();


        String remoteUrl = System.getenv().getOrDefault(
                "SELENIUM_REMOTE_URL",
                "http://host.docker.internal:4444/wd/hub"
        );

        driver = new TestiniumSeleniumDriver(new URL(remoteUrl), options);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
