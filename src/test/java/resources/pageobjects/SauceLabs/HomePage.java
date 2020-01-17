package resources.pageobjects.SauceLabs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    //Konstruktor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://saucelabs.com/");
    }
    //Elementi
    @FindBy(how = How.XPATH, using = "//*[@class='link has-text-white' and contains(text(),'Sign in')]")
    private WebElement signInButton;
    public void userIsOnSignInPage(){
        Assert.assertTrue(driver.getTitle().contains("Sauce Labs"));
    }
    public void clickOnSignIn(){
        signInButton.click();
    }
}
