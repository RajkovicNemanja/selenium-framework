package core.com.automationpractice;

import core.TestCommon;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.SignInPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

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
        //Verify that this is sign in page
        assertTrue(signInPage.isThisCurrentPage());
        //TODO set parameter values from the external document
        signInPage.enterEmailSignIn("email.for.testing@tutanota.com");
        signInPage.enterPasswordSignIn("SuperSecret123?");
        //Return the new page after navigation, 
        MyAccountPage myAccountPage = signInPage.pressSignInButton();
        //Verify that sign in is completed successfully
        assertTrue(myAccountPage.isThisCurrentPage());
    }

    @Test
    public void verifyTextOnPage()
    {
        //TODO: get String values from an external file
        //Verify that the main page title has the appropriate value
        assertEquals("AUTHENTICATION", signInPage.getPageHeadingText());
        //Verify that create account form title has the appropriate value
        assertEquals("CREATE AN ACCOUNT", signInPage.getCreateAccountFormHeadingText());
        //Verify that log in form title has the appropriate value
        assertEquals("ALREADY REGISTERED?", signInPage.getLogInFormHeadingText());
        //TODO: create the same for all visible text on SignInPage
    }
}
