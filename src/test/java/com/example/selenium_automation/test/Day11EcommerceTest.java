package com.example.selenium_automation.test;

import com.example.selenium_automation.pages.Day11Ecommerce.ShopCheckoutPage;
import com.example.selenium_automation.pages.Day11Ecommerce.ShopDetailPage;
import com.example.selenium_automation.pages.Day11Ecommerce.ShopHomePage;
import com.example.selenium_automation.pages.Day11Ecommerce.ShopListPage;
import com.example.selenium_automation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Day11EcommerceTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.polymer-project.org/");
    }

    @Test(priority = 1)
    @Parameters({"category"})
    public void ecommerceHomeSuite(String category) {
        new ShopHomePage().tabSelection(category);
    }

    @Test(priority = 2)
    @Parameters({"product"})
    public void ecommerceListSuite(String product) {
        new ShopListPage().productSelection(product);
    }

    @Test(priority = 3)
    public void ecommerceDetailSuite() {
        ShopDetailPage detailPage = new ShopDetailPage();
        detailPage.addToCart();
        detailPage.clickCartModalButton();
    }

    @Test(priority = 4)
    public void ecommerceCheckoutPage() {
        ShopCheckoutPage checkoutPage = new ShopCheckoutPage();
        checkoutPage.checkoutForm();
        checkoutPage.formSubmission();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
