package resources;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    @Before
    public WebDriver setup() {
        String operatingSystem = System.getProperty("os.name");
        if ((operatingSystem).contains("Win")) {
            System.setProperty("webdriver.chrome.driver", "drivers/win/chromedriver.exe");
        } else if ((operatingSystem).contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "drivers/linux/chromedriver");
        } else if ((operatingSystem).contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "drivers/macos/chromedriver");
        }
        System.out.println(operatingSystem);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver;
    }



    @After
    public void quitDriver() {
        driver.quit();
    }
}

