package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HeaderPageFactory;
import pages.LoginPageFactory;

public class LoginTest {
    private LoginPageFactory loginPage;
    private HeaderPageFactory headerPage;
    private WebDriverWait driverWait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPageFactory(driver, driverWait);
        headerPage = new HeaderPageFactory(driver, driverWait);
        driver.manage().window().maximize();
        driver.get("http://webstation.teletrader.com/WebStation.aspx");
    }

    @Test
    public void test() {

        //1) LOGIN
        //1.0 Failed login

        loginPage.sendKeysUsernamePlaceholder("ivan.coric91");
        loginPage.sendKeysPasswordPlaceholder("ICtrader123");
        loginPage.clickLoginButton();
        String errorAcceptEULA = "You have to accept the End User License Agreement in order to log in.";
        loginPage.compareErrorMessage(errorAcceptEULA);
        //2.0	Successful login
        loginPage.sendKeysUsernamePlaceholder("ivan.coric91");
        loginPage.sendKeysPasswordPlaceholder("ICtrader123");
        loginPage.checkEula();
        loginPage.clickLoginButton();
        headerPage.isLogoVisible();
        //3. Logout
        //1. Click on “Customize and control” menu button.
        headerPage.clickUserButton();
        //2. When pop-up appears, click on "Logout" link.
        headerPage.clickLogout();
        //Test Outcome Login page should appear with empty username and password text box.
        // „EULA“ and „Stay logged in“ are selected.
        loginPage.statusOfAutoLogin();
        loginPage.statusOfEulaCheckbox();

    }

    @AfterTest
    protected void tearDown() {
    }
}
