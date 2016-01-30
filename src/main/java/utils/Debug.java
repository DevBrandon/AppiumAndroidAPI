package utils;

import api.android.Android;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Artur Spirin on 1/29/16.
 **/
public class Debug {

    public static Android android;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "ZX1G22BV8Z");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("app", "./build/unlock_apk/unlock_apk-debug.apk");
        new DriverManager(new URL("http://0.0.0.0:4722/wd/hub"), desiredCapabilities);
        android = DriverManager.getAndroid();
    }

    @AfterClass
    public static void finisher(){
        android.driver.quit();
    }
}