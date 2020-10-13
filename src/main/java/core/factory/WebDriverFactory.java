package core.factory;

import core.constants.CoreConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory
{
    public WebDriver getDriver(final String browserName)
    {
        //Instantiates Chrome driver if browserName was blank String
        if(StringUtils.isBlank(browserName)) return instantiateChromeDriver();

        switch (browserName.toUpperCase())
        {
            case CoreConstants.Browsers.CHROME :
                return instantiateChromeDriver();
            case CoreConstants.Browsers.FIREFOX :
                return instantiateFirefoxDriver();
            default:
                return instantiateChromeDriver() ;
        }
    }

    private WebDriver instantiateChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver instantiateFirefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
