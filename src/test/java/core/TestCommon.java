package core;

import core.constants.CoreConstants;
import core.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class TestCommon
{
    private static WebDriverFactory webDriverFactory;
    //Declare WebDriver which is going to be used in all test classes
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp()
    {
        webDriverFactory = new WebDriverFactory();
        //TODO: Use parametrization instead of constant as parameter value
        driver = webDriverFactory.getDriver(CoreConstants.Browsers.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void deleteCookies()
    {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void closeDriver()
    {
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    protected void explicitWait()
    {
        //TODO create eplixit wait
    }

    protected void fluentWait()
    {
        //TODO fluent wait
    }
}
