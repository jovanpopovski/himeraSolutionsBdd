package resources.pageobjects.SauceLabs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private WebDriver driver;
    //Konstruktor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Elementi
    @FindBy(how = How.XPATH, using = "//*[@class='SauceLogo__default__3k5gh']")
    private WebElement logo;

    public void waitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='SauceLogo__default__3k5gh']")));
    }

    public boolean isLogoDisplayed(){
        Assert.assertEquals("Sauce Labs | Login",driver.getTitle());
        return logo.isDisplayed();
    }
}
