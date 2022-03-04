import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
//import org.asynchttpclient.uri.Uri;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass extends ExtentReportDemo {

//    WebDriver webDriver;
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
//    AndroidDriver androidDriver;

//    public static void main(String[] args) {
//
//        try {
//            openCalclutaor();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

    @BeforeMethod
    public void BaseClass() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Galaxy A30");
        cap.setCapability("udid","R58M829Q3WD");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","10");
        cap.setCapability("app","F:\\recharge\\Simpleappiumjava\\apkPath\\app-debug.apk");
//        cap.setCapability("appPackage","com.example.basicapp");:
        cap.setCapability("appActivity","com.example.basicapp.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, cap);
        wait = new WebDriverWait(driver, 5);
        System.out.println("app started .....");
    }
}
