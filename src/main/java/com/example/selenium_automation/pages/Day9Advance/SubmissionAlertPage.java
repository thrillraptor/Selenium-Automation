package com.example.selenium_automation.pages.Day9Advance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SubmissionAlertPage extends BaseAdvancePage {
    WebElement submissionAlert;
    public WebElement alertMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
        submissionAlert = driver.findElement(alert);
        return submissionAlert;
    }
}
