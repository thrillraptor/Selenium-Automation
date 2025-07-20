package com.example.selenium_automation.pages.Day7POM;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateTaskPage extends BaseTaskPage {
    public void createTask(String title, String note) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='note-taker']")));
        noteDetails(title, note);
        addNoteClick();
    }
}