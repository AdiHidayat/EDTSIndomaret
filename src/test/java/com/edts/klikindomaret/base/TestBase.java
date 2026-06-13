package com.edts.klikindomaret.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class TestBase {

    protected AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android");
        options.setNoReset(true);
        options.setAutoGrantPermissions(true);
        //options.amend("noReset", true);

        options.amend("ignoreHiddenApiPolicyError", true);
        options.setAppPackage("com.indomaret.klikindomaret");
        options.setAppActivity("com.indomaret.klikindomaret.ngsCexmFBytBw");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        Thread.sleep(10000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}