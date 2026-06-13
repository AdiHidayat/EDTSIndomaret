package com.edts.klikindomaret.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends com.edts.klikindomaret.pages.PageBase
{
    private AndroidDriver driver;

    public HomePage(AndroidDriver driver)
    {
        super(driver);
    }


    private final String CLOSE_POPUP = "com.indomaret.klikindomaret:id/58n";
    private  final String TXT_SEARCH = "com.indomaret.klikindomaret:id/5rm";
    private final String CART = "com.indomaret.klikindomaret:id/3rg";

    public void closePopUp()
    {

        if (isElementPresent(CLOSE_POPUP)) {

            waitAndFindById(CLOSE_POPUP).click();
            System.out.println("Confirm Order clicked");

        } else {

            System.out.println("Confirm Order not displayed");
        }

    }

    public void tapTxtSearch()
    {
        waitAndFindById(TXT_SEARCH).click();
    }

    public void tapCart()
    {
        waitAndFindById(CART).click();
    }

    public void doSearch(String item)
    {
        sendKeysByXpath("//android.widget.EditText",item);
    }




}
