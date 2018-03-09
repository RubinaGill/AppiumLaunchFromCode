package Test;

import AppiumSupport.AppiumBaseClass;
import AppiumSupport.AppiumLauncher;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.ITestContext;
import org.testng.annotations.*;

/**
 * This class will take care of setUp phase
 */
public class AbstractTest {
    private AppiumDriver driver;
    protected static HRDirectLite app;
    //  private AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    @BeforeSuite
    public void launchAppium() {
        AppiumLauncher.runProcess(true, "appium -a 127.0.0.1");
    }

    @BeforeTest
    public void setUp(ITestContext context) throws Exception {

        //get device name from testng.xml's test name
        String deviceName = context.getCurrentXmlTest().getName();

        //instantiate driver according to platform
        switch (getPlatform(deviceName)) {
            case MobilePlatform.ANDROID:
                this.driver = AppiumBaseClass.forAndroid().build(deviceName);
                break;
            case MobilePlatform.IOS:
                this.driver = AppiumBaseClass.forIOS().build(deviceName);
                break;
            default:
                break;
        }

        //to accept alert pop up for sending notifications, right now disabled as currently alert is only on IOS, for ios, it is handled in IOSDriverBuilder class
        //  driver.switchTo().alert().accept();
        app = new HRDirectLite(driver);
    }


    /**
     * @param deviceName, name of device to launch
     * @return platform, returns IOS if device name starts with i
     */
    private String getPlatform(String deviceName) {
        String platform;
        if (deviceName.startsWith("i")) {
            platform = MobilePlatform.IOS;
        } else {
            platform = MobilePlatform.ANDROID;
        }
        return platform;
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
