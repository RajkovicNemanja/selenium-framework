package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject
{
    protected WebDriver webDriver;

    public PageObject(final WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public abstract boolean isThisCurrentPage();
}
