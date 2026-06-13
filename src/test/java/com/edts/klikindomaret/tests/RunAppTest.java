package com.edts.klikindomaret.tests;

import com.edts.klikindomaret.base.TestBase;
import com.edts.klikindomaret.pages.CartPage;
import com.edts.klikindomaret.pages.HomePage;
import com.edts.klikindomaret.pages.LoginPage;
import com.edts.klikindomaret.pages.ProductPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class RunAppTest extends TestBase {

    private String productPrice;

    @Test
    public void login() throws InterruptedException {

        try
        {
            LoginPage loginPage = new LoginPage(driver);

            loginPage.openLogin();

            System.out.println("BUTTON TAPPED");

            loginPage.inputphone("085642549907");
            loginPage.clickConfirm();
            driver.navigate().back();
            loginPage.inputPassword("Bebas@123");
            loginPage.clickConfirm();
            loginPage.clikNanti();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test(dependsOnMethods = "login")
    public void searchProduct()
    {
        try
        {
            HomePage homePage = new HomePage(driver);
            driver.navigate().back();
            homePage.closePopUp();
            homePage.tapTxtSearch();
            homePage.doSearch("Kapal api");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test(dependsOnMethods = "searchProduct")
    public void productDetail()
    {
        try
        {
            ProductPage productPage = new ProductPage(driver);
            driver.navigate().back();
            productPage.tapFirtList();
            productPage.chooseitem();
            productPage.add_item();
            Thread.sleep(5000);
            productPrice = productPage.getPrice();
            System.out.println(productPrice);
            productPage.search_store();
            productPage.tapFrst_store();
            productPage.take_order();
            productPage.confim_order();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test(dependsOnMethods = "productDetail")
    public void checkOut()
    {
        try
        {
            CartPage cartPage = new CartPage(driver);
            ProductPage productPage = new ProductPage(driver);
            cartPage.tapCart();
            cartPage.typeOrder();
            cartPage.timeOrder();
            cartPage.timeOrderList();
            cartPage.confirmTime();
            Thread.sleep(10000);
            cartPage.scrollRecyclerViewDown();
            System.out.println(cartPage.getPrice());
            System.out.println(cartPage.getItem());
            System.out.println(cartPage.getAmount());

            int totalAmount = Integer.parseInt(cartPage.getPrice()) * Integer.parseInt(cartPage.getItem());
            int actualTotalAmount = Integer.parseInt(cartPage.getAmount());
            Assert.assertEquals(actualTotalAmount,totalAmount);

            cartPage.buy();
            cartPage.tapOffer();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void LogoutAndClose()
    {
       driver.quit();
    }

}