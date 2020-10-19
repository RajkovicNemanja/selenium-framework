package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(css = "lost_password")
    private WebElement forgotYourPasswodLink;

    @FindBy(name = "Sign in")
    private WebElement singInButton;

    public SignInPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmailAndPassword(final String email,
                                      final String password) {
        enterEmail(email);
        enterPassword(password);
    }

    public void enterEmail(final String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void enterPassword(final String email) {
        this.password.clear();
        this.password.sendKeys(email);
    }

    public MyAccountPage pressSignInButton()
    {
        this.singInButton.click();
        return new MyAccountPage(webDriver);
    }
}
