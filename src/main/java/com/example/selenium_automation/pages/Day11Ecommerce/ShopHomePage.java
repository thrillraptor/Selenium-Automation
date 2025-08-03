package com.example.selenium_automation.pages.Day11Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopHomePage extends BaseEcommercePage {
    public void tabSelection(String tabName) {
        WebElement appHost = wait.until(d -> {
            WebElement sh = d.findElement(By.cssSelector("shop-app"));
            sh.getShadowRoot();
            return sh;
        });

        SearchContext appRoot = appHost.getShadowRoot();

        WebElement appHeader = appRoot.findElement(By.cssSelector("app-header#header"));
        WebElement tabContainer = appHeader.findElement(By.cssSelector("#tabContainer"));

        List<WebElement> shopTabs = tabContainer.findElements(By.cssSelector("shop-tabs"));

        for (WebElement tabs: shopTabs) {
            WebElement tab = tabs.findElement(By.cssSelector("shop-tab a"));
            String tabLabel = tab.getText().trim();
            if (tabLabel.equalsIgnoreCase(tabName)) {
                tab.click();
                return;
            }
        }
    }
}