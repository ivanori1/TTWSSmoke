package com.webstation.teletrader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTest {

    WebDriver driver;
    WebDriverWait driverWait;
    String baseURL = "http://webstationtest3.ttweb.net/WebStation.aspx";
    String strUsername = "ivan.coric91";
    String strPassword = "ICtrader123";

    //Elements
    By login = (By.id("loginUser"));
    By errorContainer = (By.className("error_container_inner"));
    By eula = (By.cssSelector("[for='eulaAccepted'].checkBoxLabel"));
    By autoLogin = (By.cssSelector("[for='autologin'].checkBoxLabel"));
    By username = By.name("userName");
    By password = By.name("password");
    By logoWS = By.id("logo-ws");
    By userButton = By.id("user-button");
    By accountSettings = By.cssSelector("[href='personal_registration.aspx']");

    By resetChart = By.name("resetAllChartSettingsCheckbox");
    By ressetAll = By.name("resetAllSettingsCheckbox");
    By resetButton = By.id("resetAllSettingsButton");
    By saveButton = By.cssSelector("#modalDialog [type='submit']");
    By logout = By.cssSelector("[href='Logout.aspx']");
    By title = By.className("title");
    By headerNameDetail = By.className("header-name");
    By currentDetail = By.cssSelector(".no-top-padding .current a");

    //Navigation Buttons
    By markets = By.cssSelector(".navigation-vertical [href='securities_overview.aspx']");
    By currencies = By.cssSelector(".navigation-vertical [href='currencies_Currencies.aspx']");
    By commodities = By.cssSelector(".navigation-vertical [href='commodities.aspx']");
    By fixedIncome = By.cssSelector(".navigation-vertical [href='bonds_governmentyields.aspx']");
    By funds = By.cssSelector(".navigation-vertical [href='funds_topperformerOverview.aspx']");
    By futures = By.cssSelector(".navigation-vertical [href^='quickbar_Kursliste.aspx']");
    By news = By.cssSelector("[class*='navigation'][href*='news']");
    By calendar = By.cssSelector(".navigation-vertical [href*='company_calendar']");
    By analyzer = By.cssSelector(".navigation-vertical [href='analyzer.aspx']");
    By portfolio = By.cssSelector(".navigation-vertical [href='personal_portfolioDetail.aspx']");
    By trumpEffect = By.cssSelector(".navigation-vertical [href='quickbar_Kursliste.aspx']");
    By smartBackTester = By.cssSelector(".navigation-vertical [href='portfolio_backtester.aspx']");


    //Errors
    String errEula = "You have to accept the End User License Agreement in order to log in.";

    //CheckBoxes

    public void checkEula() {
        boolean eulaIsSelected = driver.findElement(By.xpath("//*[@id='eulaAccepted']")).isSelected();
        if (eulaIsSelected == false)
            driver.findElement(eula).click();
    }

    public void checkAutoLogin() {
        boolean autoLoginIsSelected = driver.findElement(By.xpath("//*[@id='autologin']")).isSelected();
        if (autoLoginIsSelected == false)
            driver.findElement(autoLogin).click();
    }

    public void waitElement() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void test() {
        //1) LOGIN
        //1.0 Failed login
        //1 Test case:Open WebStation login page
        //2 Test case: Click on “Login” button
        driver.findElement(login).click();
        //1.0 Test outcome: „You have to accept the End User License Agreement in order to log in..“ message appears
        Assert.assertTrue(driver.findElement(errorContainer).getText().contains(errEula));

        //2.0	Successful login
        //1 Test case:Open WebStation login page
        //2 Enter correct user name and password (maximum rights account)
        driver.findElement(username).sendKeys(strUsername);
        driver.findElement(password).sendKeys(strPassword);

        //3. Make sure that “Stay logged in” check box is selected
        checkAutoLogin();
        //4. Make sure that “EULA” check box is selected
        checkEula();
        //5. Click on “Login” button
        driver.findElement(login).click();
        //Test Outcome Webstation page opens successfully
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(logoWS)));
        Assert.assertTrue(driver.findElement(logoWS).isDisplayed());

        //3. Logout
        //1. Click on “Customize and control” menu button.
        driver.findElement(userButton).click();
        //2. When pop-up appears, click on "Logout" link.
        driver.findElement(logout).click();
        //Test Outcome Login page should appear with empty username and password text box.
        // „EULA“ and „Stay logged in“ are selected.
        waitElement();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='autologin']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='eulaAccepted']")).isSelected());

        //2) NAVIGATION ICONS
        driver.findElement(username).sendKeys(strUsername);
        driver.findElement(password).sendKeys(strPassword);
        driver.findElement(login).click();

        // 1.0 Navigation icon
        //1, Click on “Currencies” navigation icon
        driverWait.until(ExpectedConditions.elementToBeClickable(currencies));
        driver.findElement(currencies).click();
        //Test Outcome: „Currencies“ price page opens in right area with „Overview“ tab in focus.;
        Assert.assertTrue(driver.findElement(By.cssSelector(".main-pages-header.currencies")).isDisplayed());
        //2 Click on Markets navigation button
        driver.findElement(markets).click();
        //Test outcome: „Market“ tab opens in detail page
        Assert.assertTrue(driver.findElement(By.cssSelector(".main-pages-header.markets")).isDisplayed());
        //3 Click on “Fixed Income” navigation icon
        driver.findElement(fixedIncome).click();
        //Test Outcome: „Fixed Income Overview“ tab open in right area
        Assert.assertTrue(driver.findElement(By.cssSelector(".main-pages-header.fixedIncome")).isDisplayed());
        //4. Click on “Commodities” navigation icon
        driver.findElement(commodities).click();
        // Test Outcome: „Commodities“ price page opens in right area with „Overview“ tab in focus.
        Assert.assertTrue(driver.findElement(By.cssSelector(".main-pages-header.commodities")).isDisplayed());
        //5. Click on “Futures” navigation icon
        driver.findElement(futures).click();
        // Test Outcome: „Futures“ price page opens in right area with „Overview“ tab in focus.
        Assert.assertTrue(driver.findElement(By.cssSelector(".main-pages-header.futures")).isDisplayed());
        //6. Go to [Customize and control] >Account settings and change region to Germany. Click on “Funds” navigation icon
        if (! driver.findElement(funds).isDisplayed()) {
            driver.findElement(userButton).click();
            driver.findElement(accountSettings).click();
            WebElement regionBox = driver.findElement(By.id("regionBox"));
            Select region = new Select(regionBox);
            region.selectByValue("DE");
        } else {
            driver.findElement(funds).click();
        }
        //Test Outcome: „Funds Overview“ table opens in right area,
        Assert.assertTrue(driver.getCurrentUrl().contains("funds"));
        //7. Click on “News” navigation icon
        driver.findElement(news).click();
        //Test Outcome: “Latest news“ page appears in the right area.
        Assert.assertTrue(driver.findElement(By.className("breaking-the-news-title")).isDisplayed());
        //Click on “Calendar” navigation icon
        driver.findElement(calendar).click();
        //8.Test Outcome: “Current Week” tab is in focus
        Assert.assertTrue(driver.findElement(By.cssSelector(".main-pages-header.companyCalendar")).isDisplayed());
        //9.Click on “Analyzer” navigation icon
        driver.findElement(analyzer).click();
        //Test Outcome: “Current Week” tab is in focus
        Assert.assertTrue(driver.findElement(By.cssSelector(".main-pages-header.analyzerHeader")).isDisplayed());
        //10. Click on “Portfolio” navigation icon
        driver.findElement(portfolio).click();
        //Testoutcome: “Create new portfolio” appears in right area

    }

}
