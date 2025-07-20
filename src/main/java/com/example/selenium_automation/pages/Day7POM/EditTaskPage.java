package com.example.selenium_automation.pages.Day7POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditTaskPage extends BaseTaskPage {
    public void editTask(int index, String title, String note) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='note-taker']")));
        By editBtn = By.xpath("(//button[@class='edit-note-in-list'])["+ index +"]");

        WebElement editBtnClick = driver.findElement(editBtn);
        editBtnClick.click();

        noteDetails(title, note);

        WebElement updateNote = wait.until(ExpectedConditions.elementToBeClickable(By.id("update-note")));
        updateNote.click();
    }
}
