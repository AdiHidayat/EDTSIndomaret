package com.edts.klikindomaret.pages;

import io.appium.java_client.android.AndroidDriver;

public class ProductPage extends com.edts.klikindomaret.pages.PageBase
{
    private AndroidDriver driver;

    public ProductPage(AndroidDriver driver)
    {
        super(driver);
    }

    private final String FIRST_ROW = "com.indomaret.klikindomaret:id/b95";
    private final String ADD_CHART = "com.indomaret.klikindomaret:id/3s";
    private final String SINGLE_PRICE = "com.indomaret.klikindomaret:id/es";
    private final String ADD_ITEM = "com.indomaret.klikindomaret:id/fsh";
    private final String SEARCH_STORE = "com.indomaret.klikindomaret:id/56s";
    private final String FIRST_STORE = "com.indomaret.klikindomaret:id/3ih";
    private final String TAKE_ORDER = "com.indomaret.klikindomaret:id/a6o";
    private final String CONFIRM_ORDER = "com.indomaret.klikindomaret:id/3b";



    public void tapFirtList()
    {
        waitAndFindById("com.indomaret.klikindomaret:id/a87").click();
    }
    public void chooseitem()
    {
        waitAndFindById(FIRST_ROW).click();
        waitAndFindById(ADD_CHART).click();
    }
    public void add_item()
    {
        waitAndFindById(ADD_ITEM).click();
    }

    public void search_store()
    {
        waitAndFindById(SEARCH_STORE).click();
    }

    public void tapFrst_store()
    {
        waitAndFindById(FIRST_STORE).click();
    }

    public void take_order()
    {
        waitAndFindById(TAKE_ORDER).click();
    }

    public void confim_order()
    {
        if (isElementPresent(CONFIRM_ORDER)) {

            waitAndFindById(CONFIRM_ORDER).click();
            System.out.println("Confirm Order clicked");

        } else {

            System.out.println("Confirm Order not displayed");
        }
    }




    public String getPrice()
    {
        String priceElement = waitAndFindById(SINGLE_PRICE).getText();

        return priceElement
                .replace("Rp", "")
                .replace(".", "")
                .trim();
    }


}
