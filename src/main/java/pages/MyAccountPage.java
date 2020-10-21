package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject
{
    @FindBy(className = "page-heading")
    private WebElement myAccountPageTitle;

    @FindBy(className = "info-account")
    private WebElement infoParagraph;

    @FindBy(xpath = "//a[@title='Orders']")
    private WebElement orderHistoryAndDetailsButton;

    @FindBy(xpath = "//a[@title='Credit slips']")
    private WebElement creditSlipsButton;

    @FindBy(xpath = "//a[@title='Addresses']")
    private WebElement addressesButton;

    @FindBy(xpath = "//a[@title='Information']")
    private WebElement personalInformationButton;

    @FindBy(xpath = "//a[@title='My wishlists']")
    private WebElement myWishlistsButton;

    @FindBy(xpath = "//a[@title='Home']")
    private WebElement homeButton;

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isThisCurrentPage()
    {
        return myAccountPageTitle.isDisplayed();
    }

    public HomePage pressHomeButton()
    {
        this.homeButton.click();
        return new HomePage(webDriver);
    }
}
