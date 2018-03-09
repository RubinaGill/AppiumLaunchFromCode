package Screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class contains methods representing user interactions on Login Screen
 */
public class LoginScreen extends AbstractScreen {

    public LoginScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
