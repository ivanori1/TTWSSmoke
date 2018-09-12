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
import pages.NavigationPageFactory;

public class LoginTest {
    private LoginPageFactory loginPage;
    private HeaderPageFactory headerPage;
    private WebDriverWait driverWait;
    private NavigationPageFactory navigationPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPageFactory(driver);
        headerPage = new HeaderPageFactory(driver);
        navigationPage = new NavigationPageFactory(driver);
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
        //3. NAVIGATION ICONS
        //Click Crypto page
        loginPage.sendKeysUsernamePlaceholder("ivan.coric91");
        loginPage.sendKeysPasswordPlaceholder("ICtrader123");
        loginPage.clickLoginButton();
        headerPage.isLogoVisible();
        //1, Click on “Currencies” navigation icon
        navigationPage.clickCurrenciesNavigation();
        //Test Outcome: „Currencies“ price page opens in right area with „Overview“ tab in focus.;
        navigationPage.isCurrencyHeaderVisible();
        //2 Click on Markets navigation button
        navigationPage.clickMarketButton();
        //2 Click on Markets navigation button
        navigationPage.clickMarketButton();
        //Test outcome: „Market“ tab opens in detail page
        navigationPage.isMarketHeaderVisible();
        //3 Click on “Fixed Income” navigation icon
        navigationPage.clickFixedIncome();
        //Test Outcome: „Fixed Income Overview“ tab open in right area
        navigationPage.isFixedIncomeHeaderVisible();
        //4. Click on “Commodities” navigation icon
        navigationPage.clickCommoditiesButton();
        // Test Outcome: „Commodities“ price page opens in right area with „Overview“ tab in focus.
        navigationPage.isCommoditiesHeaderVisible();
        //5. Click on “Futures” navigation icon
        navigationPage.clickFuturesButton();
        // Test Outcome: „Futures“ price page opens in right area with „Overview“ tab in focus.
        navigationPage.isFuturesHeaderVisible();
        //7. Click on “News” navigation icon
        navigationPage.clickNewsButton();
        //Test Outcome: “Latest news“ page appears in the right area.
        navigationPage.isNewsHeaderVisible();
        //Click on “Calendar” navigation icon
        navigationPage.clickCalendar();
        //8.Test Outcome: “Current Week” tab is in focus
        navigationPage.isCalendarButtonVisible();
        //9.Click on “Analyzer” navigation icon
        navigationPage.clickOnAnalyzerButton();
        //Test Outcome: “Current Week” tab is in focus
        navigationPage.isAnalyzerHeaderVisible();


    }

    @AfterTest
    protected void tearDown() {
    }
}
