package com.testinium.selenium4javakartal.tests;

import com.testinium.selenium4javakartal.baseTest.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void openAmazonAndPrintTitle() {
        driver.get("https://www.amazon.com");
        System.out.println("Page title: " + driver.getTitle());
        assertTrue(driver.getTitle() != null && !driver.getTitle().isEmpty());
    }

    @Test
    public void openAmazonAndFailOnWrongTitle() {
        driver.get("https://www.amazon.com");

        // Bilerek yanlış bir beklenti
        assertEquals(
                "Google",
                driver.getTitle(),
                "Title bilerek yanlış verildi, test fail olmalı"
        );
    }
}
