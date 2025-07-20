package com.example.selenium_automation.test;

import com.example.selenium_automation.pages.Day7POM.CreateTaskPage;
import com.example.selenium_automation.pages.Day7POM.EditTaskPage;
import com.example.selenium_automation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day7POMTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
    }

    @Test
    public void pomTest() {
        CreateTaskPage createTaskPage = new CreateTaskPage();
        createTaskPage.createTask("Hello", "World");

        EditTaskPage editTaskPage = new EditTaskPage();
        editTaskPage.editTask(1,"what's", "Up");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
