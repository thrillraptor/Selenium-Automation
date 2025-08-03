package com.example.selenium_automation.pages.Day11Ecommerce;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShopListPage extends BaseEcommercePage {
    public void productSelection(String title) {
        WebElement listHost = wait.until(d -> {
            WebElement sl = d.findElement(By.cssSelector("shop-app"))
                .getShadowRoot()
                .findElement(By.cssSelector("iron-pages shop-list[visible]"));
            sl.getShadowRoot();
            return sl;
        });

        final By ROW_LOCATOR = By.cssSelector("ul.grid li > a");

        wait.until(d -> {
            List<WebElement> rows = listHost.getShadowRoot().findElements(ROW_LOCATOR);
            return rows.isEmpty() ? null : rows;
        });

        int total = listHost.getShadowRoot().findElements(ROW_LOCATOR).size();

        for (int i = 0; i < total; i++) {
            WebElement anchor = listHost.getShadowRoot().findElements(ROW_LOCATOR).get(i);

            SearchContext item = anchor
                .findElement(By.cssSelector("shop-list-item"))
                .getShadowRoot();

            String text = item.findElement(By.cssSelector(".title")).getText().trim();
            if (title.equalsIgnoreCase(text)) {
                wait.until(ExpectedConditions.elementToBeClickable(anchor)).click();
                return;
            }
        }
        throw new NoSuchElementException("Product '" + title + "' not found");
    }
}