package com.edts.klikindomaret.pages;

import io.appium.java_client.android.AndroidDriver;

public class CartPage extends com.edts.klikindomaret.pages.PageBase
{
    private AndroidDriver driver;

    public CartPage(AndroidDriver driver)
    {
        super(driver);
    }


    private final String CART= "com.indomaret.klikindomaret:id/3rg";
    private final String BUY = "com.indomaret.klikindomaret:id/frj";

    private final String TYPE_ORDER ="com.indomaret.klikindomaret:id/43p";
    private final String TIME_ORDER ="com.indomaret.klikindomaret:id/d2f";
    private final String TIME_ORDER_LIST ="com.indomaret.klikindomaret:id/abf";
    private final String CONFRIM_TIME = "com.indomaret.klikindomaret:id/did";
    private final String OFFER = "com.indomaret.klikindomaret:id/156";

    private final String TNC1= "com.indomaret.klikindomaret:id/a7e";
    private final String TNC_BUY ="com.indomaret.klikindomaret:id/3b";
    private final String AMOUNT_GOODS = "com.indomaret.klikindomaret:id/9n3";
    private final String PRICE = "com.indomaret.klikindomaret:id/es";
    private final String ITEM = "com.indomaret.klikindomaret:id/9n3";
    private final String TOTAL_AMOUNT ="com.indomaret.klikindomaret:id/fp6";

    public void tapCart()

    {
        waitAndFindById(CART).click();
    }

    public void buy()
    {
        waitAndFindById(BUY).click();
    }

    public void typeOrder()
    {
        waitAndFindById(TYPE_ORDER).click();
    }

    public void timeOrder()
    {
        waitAndFindById(TIME_ORDER).click();
    }

    public void timeOrderList()
    {
        waitAndFindById(TIME_ORDER_LIST).click();
    }

    public void tapOffer()
    {
        waitAndFindById(OFFER).click();
    }
    public void tnc()
    {
        waitAndFindById(TNC1).click();

    }

    public void tncBuy()
    {
        waitAndFindById(TNC_BUY).click();
    }
    public void confirmTime()
    {
        waitAndFindById(CONFRIM_TIME).click();
    }

    public String getAmount_goods()
    {
        String amountGoods = waitAndFindById(AMOUNT_GOODS).getText();
        return  amountGoods;
    }

    public String getPrice()
    {
        String priceElement = waitAndFindById(PRICE).getText();

        return priceElement
                .replace("Rp", "")
                .replace(".", "")
                .trim();
    }

    public String getItem()
    {
        String item = waitAndFindById(ITEM).getText();
        return  item;
    }

    public String getAmount()
    {
        String amount = waitAndFindById(TOTAL_AMOUNT).getText();

        return amount
                .replace("Rp", "")
                .replace(".", "")
                .trim();
    }

}
