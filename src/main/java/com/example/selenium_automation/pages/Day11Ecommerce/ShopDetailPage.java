package com.example.selenium_automation.pages.Day11Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopDetailPage extends BaseEcommercePage {
    public void addToCart () {
        WebElement detailHost = wait.until(d -> {
            WebElement sd = d.findElement(By.cssSelector("shop-app"))
                .getShadowRoot()
                .findElement(By.cssSelector("iron-pages shop-detail[visible]"));
            sd.getShadowRoot();
            return sd;
        });

        SearchContext detailRoot = detailHost.getShadowRoot();

        final By SIZE_LOCATOR = By.cssSelector("div#content .detail .pickers shop-select select#sizeSelect");
        final By QUANTITY_LOCATOR = By.cssSelector("div#content .detail .pickers shop-select select#quantitySelect");
        final By ADD_TO_CART_LOCATOR = By.cssSelector("shop-button button");

        WebElement sizeSelect = detailRoot.findElement(SIZE_LOCATOR);
        WebElement quantitySelect = detailRoot.findElement(QUANTITY_LOCATOR);

        new Select(sizeSelect).selectByVisibleText("L");
        new Select(quantitySelect).selectByVisibleText("2");

        WebElement addToCart = detailRoot.findElement(ADD_TO_CART_LOCATOR);
        addToCart.click();
    }

    public void clickCartModalButton() {
        WebElement appRoot = wait.until(d -> d.findElement(By.cssSelector("shop-app")));
        SearchContext appShadow = appRoot.getShadowRoot();

        WebElement cartModal = appShadow.findElement(By.cssSelector("shop-cart-modal"));
        SearchContext cartModalShadow = cartModal.getShadowRoot();

        List<WebElement> modalButtons = cartModalShadow.findElements(By.cssSelector("div.layout-horizontal shop-button.modal-button"));
        for (WebElement button : modalButtons) {
            WebElement a = button.findElement(By.cssSelector("a"));
            String buttonLabel = a.getText().trim();
            if (buttonLabel.equalsIgnoreCase("Checkout")) {
                wait.until(ExpectedConditions.elementToBeClickable(button)).click();
                return;
            }
        }
    }
}