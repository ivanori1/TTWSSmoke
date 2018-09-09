package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPageFactory;

public class LoginTest {
    private LoginPageFactory loginPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPageFactory(driver);
        driver.manage().window().maximize();
        driver.get("http://webstation.teletrader.com/WebStation.aspx");
    }

    @Test
    public void test() {

        loginPage.sendKeysUsernamePlaceholder("ivan.coric91");
        loginPage.sendKeysPasswordPlaceholder("ICtrader");
        loginPage.clickLoginButton();
        String errorAcceptEULA = "You have to accept the End User License Agreement in order to log in.";
        loginPage.compareErrorMessage(errorAcceptEULA);
    }

    @AfterTest
    protected void tearDown() {
    }
}
