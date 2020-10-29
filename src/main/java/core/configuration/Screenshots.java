package core.configuration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots
{
    public void getScreenshotPath(final WebDriver webDriver,
                                  final String imageName)
    {
        try
        {
            final TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
            final File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            final String outputLocation = System.getProperty("user.dir")+"\\reports\\screenshots\\"+imageName+".png";
            FileUtils.copyFile(source,new File(outputLocation));
        }
        catch (IOException e)
        {
            //TODO: Add logger and meaningful description
            e.printStackTrace();
        }
    }
}
