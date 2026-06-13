package com.edts.klikindomaret.pages;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends com.edts.klikindomaret.pages.PageBase {

    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver)
    {
        super(driver);
    }

    private final String NAVIGATE_AKUN = "com.indomaret.klikindomaret:id/ddq";
    private final String BTN_GABUNG = "com.indomaret.klikindomaret:id/27t";
    private final String BTN_CONFIRM= "com.indomaret.klikindomaret:id/5mp";
    private  final String BTN_NANTI = "com.indomaret.klikindomaret:id/9t1";
    private  final String LOGOUT = "com.indomaret.klikindomaret:id/c5k";


    public void openLogin() {

        waitAndFindById(NAVIGATE_AKUN).click();
        waitAndFindById(BTN_GABUNG).click();
    }

    public void akun()
    {
        waitAndFindById(NAVIGATE_AKUN).click();

    }

    public void logout()
    {
        waitAndFindById(LOGOUT).click();
    }

    public void clickConfirm()
    {
        waitAndFindById(BTN_CONFIRM).click();
    }

    public void clikNanti()
    {
        waitAndFindById(BTN_NANTI).click();
    }

    public void inputphone(String phone) {

        sendKeysByXpath("//android.widget.EditText",phone);
    }

    public void inputPassword(String password) {
        sendKeysByXpath("//android.widget.EditText[@text='Kata Sandi']", password);
    }

    public void clickLogin() {

        driver.findElement(
                        AppiumBy.id(BTN_GABUNG))
                .click();
    }
}