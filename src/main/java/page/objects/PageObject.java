package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject
{
    protected WebDriver webDriver;

    public PageObject(final WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
}
