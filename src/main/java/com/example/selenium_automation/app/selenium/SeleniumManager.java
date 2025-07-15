package com.example.selenium_automation.app.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumManager {

    public void runAmazonTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}
