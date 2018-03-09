package Test;


import org.testng.Assert;
import org.testng.annotations.Test;
import utitlity.ConfigReader;


/**
 * This class contains tests on Login Screen
 */
public class LoginScreenTest extends AbstractTest {


    @Test
    public void loginWithValidCredentials() {
        Assert.assertTrue(true);
    }

    @Test
    public void loginWithInValidCredentials(){
            Assert.assertTrue(false);
        }
}
