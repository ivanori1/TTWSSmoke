package com.webstation.teletrader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
    By searchTab = By.id("search-tab-link");
    By derivateSearch = By.cssSelector("[href='certificate_Search.aspx']");
    By derivateSearchForm = By.id("derivative-search-form");

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
    By alert = By.cssSelector(".navigation-vertical [href='personal_notifications.aspx']");
    By economicData = By.cssSelector(".navigation-vertical [href='economic_calendar.aspx']");
    By trumpEffect = By.cssSelector(".navigation-vertical [href='trump_effect.aspx']");
    By smartBackTester = By.cssSelector(".navigation-vertical [href='portfolio_backtester.aspx']");
    By screener = By.cssSelector(".navigation-vertical [href='screener_overview.aspx']");
    By etf = By.cssSelector(".navigation-vertical [href='funds_etfOverview.aspx']");
    By realTime = By.cssSelector(".navigation-vertical [href='realtime_Indications.aspx']");

    //Detail page headers
    By currenciesHeader = By.cssSelector(".main-pages-header.currencies");
    By marketsHeader = By.cssSelector(".main-pages-header.markets");
    By fixedIncomeHeader = By.cssSelector(".main-pages-header.fixedIncome");
    By commoditiesHeader = By.cssSelector(".main-pages-header.commodities");
    By futuresHeader = By.cssSelector(".main-pages-header.futures");
    By newsHeader = By.className("breaking-the-news-title");
    By calendarHeader = By.cssSelector(".main-pages-header.companyCalendar");
    By analyzerHeader = By.cssSelector(".main-pages-header.analyzerHeader");
    By portfolioHeader = By.cssSelector(".main-pages-header.portfolio");
    By alertHeader = By.cssSelector(".main-pages-header.alerts");
    By trumpEffectHeader = By.cssSelector(".main-pages-header.trumpEfect");
    By economicDataHeader = By.cssSelector(".main-pages-header.economicCalendar");
    By backTesterHeader = By.cssSelector(".backtester-header.back-tester");
    By screenerHeader = By.cssSelector(".main-pages-header.screenerHeader");
    By etfHeader = By.cssSelector(".main-pages-header.etf");
    By realTimeHeader = By.cssSelector(".main-pages-header.realtimeIn");

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
        Assert.assertTrue(driver.findElement(currenciesHeader).isDisplayed());
        //2 Click on Markets navigation button
        driver.findElement(markets).click();
        //Test outcome: „Market“ tab opens in detail page
        Assert.assertTrue(driver.findElement(marketsHeader).isDisplayed());
        //3 Click on “Fixed Income” navigation icon
        driver.findElement(fixedIncome).click();
        //Test Outcome: „Fixed Income Overview“ tab open in right area
        Assert.assertTrue(driver.findElement(fixedIncomeHeader).isDisplayed());
        //4. Click on “Commodities” navigation icon
        driver.findElement(commodities).click();
        // Test Outcome: „Commodities“ price page opens in right area with „Overview“ tab in focus.
        Assert.assertTrue(driver.findElement(commoditiesHeader).isDisplayed());
        //5. Click on “Futures” navigation icon
        driver.findElement(futures).click();
        // Test Outcome: „Futures“ price page opens in right area with „Overview“ tab in focus.
        Assert.assertTrue(driver.findElement(futuresHeader).isDisplayed());
        //6. Go to [Customize and control] >Account settings and change region to Germany. Click on “Funds” navigation icon
        if (driver.findElements(funds).isEmpty()) {
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
        Assert.assertTrue(driver.findElement(newsHeader).isDisplayed());
        //Click on “Calendar” navigation icon
        driver.findElement(calendar).click();
        //8.Test Outcome: “Current Week” tab is in focus
        Assert.assertTrue(driver.findElement(calendarHeader).isDisplayed());
        //9.Click on “Analyzer” navigation icon
        driver.findElement(analyzer).click();
        //Test Outcome: “Current Week” tab is in focus
        Assert.assertTrue(driver.findElement(analyzerHeader).isDisplayed());
        //10. Click on “Portfolio” navigation icon
        driver.findElement(portfolio).click();
        //Testoutcome: “Create new portfolio” appears in right area
        Assert.assertTrue(driver.findElement(portfolioHeader).isDisplayed());
        //11. Click on “Alerts” navigation icon
        driver.findElement(alert).click();
        //TestOutcome: “Notifications” headline appears in right area
        Assert.assertTrue(driver.findElement(alertHeader).isDisplayed());
        //12. Search overview tab: Click on “Derivatives search” tab in right area
        driver.findElement(searchTab).click();
        driver.findElement(derivateSearch).click();
        //Test Outcome: “Derivatives search” tab appears in right area
        Assert.assertTrue(driver.findElement(derivateSearchForm).isDisplayed());
        //13. Click on “Economic Data” navigation icon from (from list of additional icons)
        driver.findElement(economicData).click();
        //Test Outcome: “Filter Events” tab appears in right area
        Assert.assertTrue(driver.findElement(economicDataHeader).isDisplayed());
        //14. Click on “Trump Effect” navigation icon
        driver.findElement(trumpEffect).click();
        //TestOutcome: “Trump Effect” will appear with mini graphs, news and twit wall
        Assert.assertTrue(driver.findElement(trumpEffectHeader).isDisplayed());
        //14. Click on “Trump Effect” navigation icon
        driver.findElement(smartBackTester).click();
        //Test Outcome: “Portfolio Bakctester” will appear.
        Assert.assertTrue(driver.findElement(backTesterHeader).isDisplayed());
        //16. Click on “Screener”
        driver.findElement(screener).click();
        //TestOutcome: Saved screener tab will appear
        Assert.assertTrue(driver.findElement(screenerHeader).isDisplayed());
        //17. Click on ETF navigation icon
        driver.findElement(etf).click();
        //Test Outcome: ETFS overview will appear
        Assert.assertTrue(driver.findElement(etfHeader).isDisplayed());
        //18. Click on “Real Time” icon
        driver.findElement(realTime).click();
        //Test Outcome: Indices with real time will appear
        Assert.assertTrue(driver.findElement(realTimeHeader).isDisplayed());
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
