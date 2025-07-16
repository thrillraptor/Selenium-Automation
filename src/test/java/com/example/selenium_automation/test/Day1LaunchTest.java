package com.example.selenium_automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Test;

public class Day1LaunchTest {
    @Test
    public void LaunchTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
