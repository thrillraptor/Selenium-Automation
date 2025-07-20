package com.example.selenium_automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.time.Duration;

public class Day5LoginTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest(){
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form")));

        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        usernameInput.clear();
        usernameInput.sendKeys("student");

        passwordInput.clear();
        usernameInput.sendKeys("wrong@Password");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(errorMsg.isDisplayed(),"Error message is not displayed.");
        Assert.assertEquals(errorMsg.getText(), "Your username is invalid!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
