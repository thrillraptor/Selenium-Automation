package com.example.selenium_automation.test;

import com.example.selenium_automation.pages.Day9Advance.FormSubmissionPage;
import com.example.selenium_automation.pages.Day9Advance.SubmissionAlertPage;
import com.example.selenium_automation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day9AdvanceTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("https://formy-project.herokuapp.com/form");
    }

    @Test
    public void FormTest() {
        FormSubmissionPage formSubmissionPage = new FormSubmissionPage();
        formSubmissionPage.formSubmission("John", "Wick", "AWS Dev", "Grad School", "Male", "0-1", "07/25/2025");

        SubmissionAlertPage submissionAlertPage = new SubmissionAlertPage();

        Assert.assertTrue(submissionAlertPage.alertMessage().isDisplayed(), "Alert message is not displayed.");
        Assert.assertEquals(submissionAlertPage.alertMessage().getText(), "The form was successfully submitted!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}