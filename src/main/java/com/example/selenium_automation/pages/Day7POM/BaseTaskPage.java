package com.example.selenium_automation.pages.Day7POM;

import com.example.selenium_automation.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTaskPage {
    protected WebDriver driver = DriverFactory.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    protected By titleField = By.id("note-title-input");
    protected By noteField = By.id("note-details-input");
    protected By addNote = By.id("add-note");

    protected void noteDetails(String title, String note) {

        if (title!=null && !title.trim().isEmpty()) {
            WebElement titleInput = driver.findElement(titleField);
            titleInput.clear();
            titleInput.sendKeys(title);
        }

        if (note!=null && !note.trim().isEmpty()) {
            WebElement noteInput = driver.findElement(noteField);
            noteInput.clear();
            noteInput.sendKeys(note);
        }
    }

    protected void addNoteClick() {
        driver.findElement(addNote).click();
    }
}
