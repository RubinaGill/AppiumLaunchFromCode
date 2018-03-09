package AppiumSupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utitlity.ConfigReader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class will sets the needed capabilities and instantiates the Android driver
 */
public class IOSDriverBuilder extends AppiumBaseClass<IOSDriverBuilder, IOSDriver> {


  //  public static IOSDriverBuilder instance = new IOSDriverBuilder();
    private DesiredCapabilities capabilities = new DesiredCapabilities();



    public IOSDriver build(String deviceName) throws MalformedURLException {

        //getting directory path where app files are placed
        File classpathRoot = new File(System.getProperty("user.dir"));
        File applicationDir = new File(classpathRoot, ConfigReader.getProperty("applicationDir"));

        //mandatory capabilities for IOS platform

        //fetching sub directory for ipa
        File iapp = new File(applicationDir, "IOS");
        File iOSApp = new File(iapp, "HitList.app");

        //setting capabilities
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "10.3");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", iOSApp.getAbsolutePath());
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("newCommandTimeout", 60);
        capabilities.setCapability("autoWebview", true);
        capabilities.setCapability("autoAcceptAlerts", true);


        //creating IOSDriver from capabilities passed
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.switchTo().alert().accept();
        return driver;
    }
}
