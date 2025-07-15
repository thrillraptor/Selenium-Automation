package com.example.selenium_automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.selenium_automation.app.selenium.SeleniumManager;

@SpringBootApplication
public class SeleniumAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumAutomationApplication.class, args);

		SeleniumManager manager = new SeleniumManager();
		manager.runAmazonTest();
	}
}
