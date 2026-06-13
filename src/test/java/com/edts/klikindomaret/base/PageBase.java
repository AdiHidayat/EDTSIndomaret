package com.edts.klikindomaret.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.Map;

public class PageBase {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public PageBase(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected WebElement waitAndFindById(String id) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id(id)
                )
        );
    }

    protected WebElement waitAndFindByXpath(String xpath) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath(xpath)
                )
        );
    }

    protected void sendKeysById(String id, String text) {
        WebElement element = waitAndFindById(id);
        element.clear();
        element.sendKeys(text);
    }

    protected void sendKeysByXpath(String xpath, String text) {
        WebElement element = waitAndFindByXpath(xpath);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isElementPresent(String id) {
        return driver.findElements(AppiumBy.id(id)).size() > 0;
    }

    public void scrollDown()
    {
        driver.executeScript("mobile: scrollGesture", Map.of(
                "left", 0,
                "top", 500,
                "width", 1080,
                "height", 1800,
                "direction", "up",
                "percent", 3.0

        ));

    }
}