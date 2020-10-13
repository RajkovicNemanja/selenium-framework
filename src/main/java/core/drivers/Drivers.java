package core.drivers;

import core.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used to initialize the driver,
 * based on values ​​from the props file.
 */
public class Drivers
{

    private WebDriver webDriver;

    public WebDriver InitializeDriver()
    {
        //TODO: replace path String values with Enumerations wherever possible
        try
        {
            final Properties props = new Properties();
            //TODO: find better way to read file with relative path
            final String path = "C:\\Users\\Drazenko\\Desktop\\projekti-portfolio\\selenium-framework\\src\\main\\java\\core\\properties\\data.properties";
            final FileInputStream fileInputStream = new FileInputStream(path);
            final WebDriverFactory webDriverFactory = new WebDriverFactory();

            props.load(fileInputStream);
            //Uses factory design pattern to instantiate web drivers
            webDriver = webDriverFactory.getDriver(props.getProperty("browser"));
            fileInputStream.close();
        }
        catch (FileNotFoundException e)
        {
            //TODO: log exception with logger
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return webDriver;
    }
}
