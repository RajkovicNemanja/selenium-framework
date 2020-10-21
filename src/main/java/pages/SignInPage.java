package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {

    @FindBy(className = "home")
    private WebElement homeButton;

    @FindBy(className = "page-heading")
    private WebElement pageHeading;

    @FindBy(className = "navigation_page")
    private WebElement authenticationSpan;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(className = "lost_password")
    private WebElement forgotYourPasswodLink;

    @FindBy(id = "SubmitLogin")
    private WebElement singInButton;

    public SignInPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isThisCurrentPage()
    {
        return pageHeading.isDisplayed();
    }

    public void enterEmailAndPassword(final String email,
                                      final String password) {
        enterEmailSignIn(email);
        enterPasswordSignIn(password);
    }

    public void enterEmailSignIn(final String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void enterPasswordSignIn(final String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public MyAccountPage pressSignInButton()
    {
        this.singInButton.click();
        return new MyAccountPage(webDriver);
    }

    public boolean isHomeButtonDisplayed()
    {
        return isWebElementDisplayed(homeButton);
    }

    public boolean isAuthenticationSpanDisplayed()
    {
        return isWebElementDisplayed(authenticationSpan);
    }

    private boolean isWebElementDisplayed( final WebElement webElement )
    {
        return webElement.isDisplayed();
    }
}
