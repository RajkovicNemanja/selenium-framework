package core.com.automationpractice;

import core.TestCommon;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.SignInPage;

import static org.testng.Assert.assertTrue;

public class SignInPageTest extends TestCommon
{
    private SignInPage signInPage;

    @BeforeMethod
    public void beforeMethod()
    {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        //TODO: create page factory
        signInPage = new SignInPage(driver);
    }

    @Test
    public void verifyWebElementsDisplay()
    {
        //Verify that home button is displayed
        assertTrue(signInPage.isHomeButtonDisplayed());
        //Verify that authentication span is displayed
        assertTrue(signInPage.isAuthenticationSpanDisplayed());
        //TODO create this for every element on SingipPage
    }

    @Test
    public void verifySignInFunctionality()
    {
        //TODO set parameter values from the external document
        signInPage.enterEmailSignIn("email.for.testing@tutanota.com");
        signInPage.enterPasswordSignIn("SuperSecret123?");

        MyAccountPage myAccountPage = signInPage.pressSignInButton();
        //Verify that SignIn is completed successfully
        assertTrue(myAccountPage.isThisCurrentPage());
    }
}
