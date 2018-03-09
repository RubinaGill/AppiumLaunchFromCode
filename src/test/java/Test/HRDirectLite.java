package Test;

import Screens.*;
import io.appium.java_client.AppiumDriver;
class HRDirectLite {
    private final AppiumDriver driver;

    HRDirectLite(AppiumDriver driver) {
        this.driver = driver;
    }

    LoginScreen loginScreen() {
        return new LoginScreen(driver);
    }

}
