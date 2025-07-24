package com.example.selenium_automation.pages.Day9Advance;

import com.example.selenium_automation.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseAdvancePage {
    protected WebDriver driver = DriverFactory.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    protected By formGroup = By.xpath("//div[@class='form-group']");

    protected By firstName = By.id("first-name");
    protected By lastName = By.id("last-name");
    protected By jobTitle = By.id("job-title");
    protected By eduLevel = By.xpath("//div[@class='col-sm-8 col-sm-offset-2'][input[@type='radio']]");
    protected By sexCheck = By.xpath("//div[@class='col-sm-8 col-sm-offset-2'][input[@type='checkbox']]");
    protected By yearsExp = By.id("select-menu");
    protected By datePick = By.id("datepicker");
    protected By submitForm = By.xpath("//a[@role='button']");

    protected By alert = By.xpath("//div[@class='alert alert-success']");
}
