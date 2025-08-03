package com.example.selenium_automation.pages.Day11Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ShopCheckoutPage extends BaseEcommercePage {
    SearchContext checkoutRoot;
    WebElement form;

    public void checkoutForm() {
        WebElement checkoutHost = wait.until(d -> {
            WebElement sc = d.findElement(By.cssSelector("shop-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("iron-pages shop-checkout[visible]"));
            sc.getShadowRoot();
            return sc;
        });

        checkoutRoot = checkoutHost.getShadowRoot();
        form = checkoutRoot.findElement(By.cssSelector("div.main-frame iron-pages#pages .iron-selected iron-form#checkoutForm"));

        final By EMAIL_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-input #accountEmail");
        final By PHONE_NUMBER_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-input #accountPhone");
        final By ADDRESS_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-input #shipAddress");
        final By CITY_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-input #shipCity");
        final By STATE_PROVINCE_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-input #shipState");
        final By ZIP_POSTAL_CODE_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-input #shipZip");
        final By COUNTRY_LOCATOR = By.cssSelector("form .subsection.grid section .column shop-select #shipCountry");
        final By CARD_HOLDER_NAME_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-input #ccName");
        final By CARD_NUMBER_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-input #ccNumber");
        final By EXP_MONTH_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row .column shop-select #ccExpMonth");
        final By EXP_YEAR_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-select #ccExpYear");
        final By CVV_LOCATOR = By.cssSelector("form .subsection.grid section .row.input-row shop-input #ccCVV");

        WebElement email = form.findElement(EMAIL_LOCATOR);
        WebElement phone = form.findElement(PHONE_NUMBER_LOCATOR);
        WebElement address = form.findElement(ADDRESS_LOCATOR);
        WebElement city = form.findElement(CITY_LOCATOR);
        WebElement state = form.findElement(STATE_PROVINCE_LOCATOR);
        WebElement zipCode = form.findElement(ZIP_POSTAL_CODE_LOCATOR);
        WebElement country = form.findElement(COUNTRY_LOCATOR);
        WebElement cardName = form.findElement(CARD_HOLDER_NAME_LOCATOR);
        WebElement cardNumber = form.findElement(CARD_NUMBER_LOCATOR);
        WebElement cardExpMonth = form.findElement(EXP_MONTH_LOCATOR);
        WebElement cardExpYear = form.findElement(EXP_YEAR_LOCATOR);
        WebElement cardCVV = form.findElement(CVV_LOCATOR);

        email.sendKeys("test@example.com");
        phone.sendKeys("1234567890");
        address.sendKeys("123 Test St.");
        city.sendKeys("Test Ville");
        state.sendKeys("Test State");
        zipCode.sendKeys("12345");
        new Select(country).selectByValue("US");
        cardName.sendKeys("John Doe");
        cardNumber.sendKeys("4111111111111111");
        new Select(cardExpMonth).selectByVisibleText("Dec");
        new Select(cardExpYear).selectByVisibleText("2016");
        cardCVV.sendKeys("123");
    }

    public void formSubmission() {
        final By PLACE_ORDER_LOCATOR = By.cssSelector("form .subsection.grid section shop-button#submitBox input");
        WebElement orderBtn = form.findElement(PLACE_ORDER_LOCATOR);
        wait.until(ExpectedConditions.elementToBeClickable(orderBtn)).click();
    }
}