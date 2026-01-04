package com.testinium.selenium4javakartal.tests;

import com.testinium.selenium4javakartal.baseTest.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void searchSelenium() {
        driver.get("https://www.google.com");

        // Dismiss cookie consent if present
        try {
            WebElement consentButton = driver.findElement(
                    By.xpath("//div[contains(@class,'VfPpkd-RLmnJb') or @id='L2AGLb']")
            );
            if (consentButton.isDisplayed()) {
                consentButton.click();
            }
        } catch (Exception ignored) {}

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        WebElement results = driver.findElement(By.id("search"));
        assertTrue(results.isDisplayed());
        assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }

    @Test
    public void openAmazonAndPrintTitle() {
        driver.get("https://www.amazon.com");
        System.out.println("Page title: " + driver.getTitle());
        assertTrue(driver.getTitle() != null && !driver.getTitle().isEmpty());
    }
}
