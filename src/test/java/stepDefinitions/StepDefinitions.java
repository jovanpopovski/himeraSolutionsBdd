package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.TestBase;
import resources.pageobjects.SauceLabs.HomePage;
import resources.pageobjects.SauceLabs.SignInPage;

public class StepDefinitions {
    private TestBase testBase = new TestBase();
    private WebDriver driver = testBase.setup();
    private HomePage homePage = new HomePage(driver);
    private SignInPage signInPage = new SignInPage(driver);

    @After
    public void killDriver() {
        driver.quit();
    }
    //Proceduralni deo testiranja SauceLabs stranice

    @Given("^User is on Sauce Labs home page$")
    public void userIsOnSauceLabsHomePage() {
        driver.get("https://saucelabs.com/");
        Assert.assertTrue(driver.getTitle().contains("Sauce Labs"));
    }

    @When("^User clicks on sign in button$")
    public void userClicksOnSignInButton() {
        driver.findElement(By.xpath("//*[@class='link has-text-white' and contains(text(),'Sign in')]")).click();
    }

    @Then("^User in on sign in page$")
    public void userInOnSignInPage() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='SauceLogo__default__3k5gh']")));
        Assert.assertEquals("Sauce Labs | Login", driver.getTitle());
    }

    //Page object deo testiranja SauceLabs stranice
    @Given("^User is on Sauce Labs home page using page object$")
    public void userIsOnSauceLabsHomePageUsingPageObject() {
        homePage.userIsOnSignInPage();
    }

    @When("^User clicks on sign in button using page object$")
    public void userClicksOnSignInButtonUsingPageObject() {
        homePage.clickOnSignIn();
    }

    @Then("^User in on sign in page using page object$")
    public void userInOnSignInPageUsingPageObject() {
        signInPage.waitForPageToLoad();
        signInPage.isLogoDisplayed();
    }
}
