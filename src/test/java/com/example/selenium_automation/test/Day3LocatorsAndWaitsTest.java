package com.example.selenium_automation.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Day3LocatorsAndWaitsTest {

    @Test
    public void LocatorsTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://youtube.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("search_query")));
            searchBox.sendKeys("Selenium Tutorials");

            By searchLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.name("search_query"));
            WebElement searchBtn = driver.findElement(searchLocator);
            searchBtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("video-title")));
        } finally {
            driver.quit();
        }
    }
}
