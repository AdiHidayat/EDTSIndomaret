package com.edts.klikindomaret.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;
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

    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                startY));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(700),
                PointerInput.Origin.viewport(),
                startX,
                endY));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }

    public void scrollRecyclerViewDown() {

        List<WebElement> scrollables = driver.findElements(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().scrollable(true)"
                )
        );

        System.out.println("Scrollable found: " + scrollables.size());

        if (scrollables.isEmpty()) {
            throw new RuntimeException("Tidak ditemukan elemen scrollable");
        }

        WebElement recyclerView = scrollables.get(0);

        System.out.println("RecyclerView Position:");
        System.out.println("X      : " + recyclerView.getRect().x);
        System.out.println("Y      : " + recyclerView.getRect().y);
        System.out.println("Width  : " + recyclerView.getRect().width);
        System.out.println("Height : " + recyclerView.getRect().height);

        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver)
                .executeScript(
                        "mobile: scrollGesture",
                        Map.of(
                                "left", recyclerView.getRect().x,
                                "top", recyclerView.getRect().y,
                                "width", recyclerView.getRect().width,
                                "height", recyclerView.getRect().height,
                                "direction", "down",
                                "percent", 0.8
                        )
                );

        System.out.println("Can Scroll More : " + canScrollMore);

    }
}