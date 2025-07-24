package com.example.selenium_automation.pages.Day9Advance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormSubmissionPage extends BaseAdvancePage {
    public void formSubmission(String firstname, String lastname, String jobtitle, String edulevel, String sexcheck, String yearsexp, String datepick) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(formGroup));

        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(jobTitle).sendKeys(jobtitle);

        List<WebElement> eduContainers = driver.findElements(eduLevel);
        for (WebElement container : eduContainers) {
            if (container.getText().trim().equalsIgnoreCase(edulevel)) {
                WebElement radio = container.findElement(By.xpath(".//input[@type='radio']"));
                if (!radio.isSelected()) {
                    radio.click();
                }
                break;
            }
        }

        List<WebElement> sexContainers = driver.findElements(sexCheck);
        for (WebElement container : sexContainers) {
            if (container.getText().trim().equalsIgnoreCase(sexcheck)) {
                WebElement checkbox = container.findElement(By.xpath(".//input[@type='checkbox']"));
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
                break;
            }
        }

        new Select(driver.findElement(yearsExp)).selectByVisibleText(yearsexp);

        WebElement dateinput = driver.findElement(datePick);
        dateinput.clear();
        dateinput.sendKeys(datepick);
        dateinput.sendKeys(Keys.RETURN);

        driver.findElement(submitForm).click();
    }
}
