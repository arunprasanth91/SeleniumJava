package com.ea.framework.base;

import com.ea.framework.config.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Karthik-PC on 11/23/2016.
 */
public class FrameworkInitialize extends Base {


    public static void InitializeBrowser(BrowserType browserType) throws MalformedURLException {

        RemoteWebDriver driver = null;
        switch (browserType)
        {
            case Chrome:
            {
                driver = new ChromeDriver();
                break;
            }
            case Firefox:
            {
                //Open the browser
                System.setProperty("webdriver.gecko.driver", "C:\\chromedriver\\geckodriver.exe");
                DesiredCapabilities capabilities= new DesiredCapabilities().firefox();

                driver= new RemoteWebDriver(new URL(Settings.SeleniumGridHub),capabilities);
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            }
            case IE:
            {
                break;
            }
        }
    }


}
