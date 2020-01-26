import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    private static final String emulator = "Pixel_2_API_28";
    private static final String loginField = "me.stasiak.loginacctivity:id/username";
    private static final String passwordField = "me.stasiak.loginacctivity:id/password";
    private static final String registerButton = "me.stasiak.loginacctivity:id/login";
    private static final String localAppPath = "/home/kamilstasiak/AndroidStudioProjects/LoginAcctivity/app/build/outputs/apk/debug/app-debug.apk";
    public static final String URL = "http://0.0.0.0:4723/wd/hub";

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("avd", emulator);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");

//         Install app
        capabilities.setCapability("app", localAppPath);

//         Start installed app
//        capabilities.setCapability("appPackage", "me.stasiak.loginacctivity");
//        capabilities.setCapability("appActivity", ".ui.login.LoginActivity");

        AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL(URL), capabilities);

        driver.findElementById(loginField).sendKeys("example@mail.com");
        driver.findElementById(passwordField).sendKeys("password");
        driver.findElementById(registerButton).click();

        driver.close();
    }
}
