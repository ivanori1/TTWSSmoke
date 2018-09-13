package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPageFactory {

    WebDriver driver;
    WebDriverWait driverWait;

    @FindBy(css = ".navigation-vertical [data-button='cu']")
    WebElement currenciesButton;

    @FindBy(css = ".main-pages-header.currencies")
    WebElement currenciesHeader;

    @FindBy(css = ".navigation-vertical [data-button='in']")
    WebElement marketButton;

    @FindBy(css = ".main-pages-header.currencies")
    WebElement marketHeader;

    @FindBy(css = ".navigation-vertical [data-button='co']")
    WebElement commoditiesButton;

    @FindBy(css = ".main-pages-header.currencies")
    WebElement commoditiesHeader;

    @FindBy(css = ".navigation-vertical [data-button='ir']")
    WebElement fixedIncomeButton;

    @FindBy(css = ".main-pages-header.currencies")
    WebElement fixedIncomeHeader;

    @FindBy(css = ".navigation-vertical [data-button='fn']")
    WebElement fundsButton;

    @FindBy(css = ".main-pages-header.currencies")
    WebElement fundsHeader;

    @FindBy(css = ".navigation-vertical [data-button='fu']")
    WebElement futuresButton;

    @FindBy(css = ".main-pages-header.currencies")
    WebElement futuresHeader;

    @FindBy(css = ".navigation-vertical [data-button='ne']")
    WebElement newsButton;

    @FindBy(css = ".main-pages-header.currencies")
    WebElement newsHeader;

    @FindBy(css = ".navigation-vertical [data-button='ca']")
    WebElement calendarButton;

    @FindBy(css = ".main-pages-header.currencies")
    WebElement calendarHeader;

    @FindBy(css = ".navigation-vertical [data-button='an']")
    WebElement analyzerButton;

    @FindBy(css = ".main-pages-header.currencies")
    WebElement analyzerHeader;

    @FindBy(css = ".navigation-vertical [data-button='po']")
    WebElement portfolioButton;

    @FindBy(css = ".main-pages-header.portfolio")
    WebElement portfolioHeader;

    @FindBy(css = ".navigation-vertical [data-button='li']")
    WebElement alertButton;

    @FindBy(css = ".main-pages-header.alerts")
    WebElement alertHeader;

    @FindBy(css = ".navigation-vertical [data-button='ec']")
    WebElement economicDataButton;

    @FindBy(css = ".main-pages-header.economicCalendar")
    WebElement economicDataHeader;

    @FindBy(css = ".navigation-vertical [data-button='te']")
    WebElement trumpEffectButton;

    @FindBy(css = ".main-pages-header.trumpEfect")
    WebElement trumpEffectHeader;

    @FindBy(css =".navigation-vertical [data-button='sc']")
    WebElement screenerButton;

    @FindBy(css =".main-pages-header.screenerHeader")
    WebElement screenerHeader;

    @FindBy(css = ".navigation-vertical [data-button='et']")
    WebElement etfButton;

    @FindBy(css = ".main-pages-header.etf")
    WebElement etfHeader;

    @FindBy(css = ".navigation-vertical [data-button='db']")
    WebElement realTimeButton;

    @FindBy(css = ".main-pages-header.realtimeIn")
    WebElement realTimeHeader;



    public NavigationPageFactory(WebDriver driver) {
        this.driver = driver;
        this.driverWait = driverWait;
        driverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void clickCurrenciesNavigation() {
        currenciesButton.click();
    }

    public void isCurrencyHeaderVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(currenciesHeader));
        assert currenciesHeader.isDisplayed();
    }

    public void clickMarketButton() {
        marketButton.click();
    }

    public void isMarketHeaderVisible() {

        driverWait.until(ExpectedConditions.visibilityOf(marketHeader));
        assert marketHeader.isDisplayed();
    }

    public void clickFixedIncome() {

        fixedIncomeButton.click();
    }

    public void isFixedIncomeHeaderVisible() {

        driverWait.until(ExpectedConditions.visibilityOf(fixedIncomeHeader));
        assert fixedIncomeHeader.isDisplayed();
    }

    public void clickCommoditiesButton() {
        commoditiesButton.click();
    }

    public void isCommoditiesHeaderVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(commoditiesHeader));
        assert commoditiesHeader.isDisplayed();
    }

    public void clickFuturesButton() {
        futuresButton.click();
    }

    public void isFuturesHeaderVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(fundsHeader));
        assert fundsHeader.isDisplayed();
    }

    public void clickNewsButton() {
        newsButton.click();
    }

    public void isNewsHeaderVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(newsHeader));
        newsHeader.isDisplayed();
    }

    public void clickCalendar() {
        calendarButton.click();
    }

    public void isCalendarButtonVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(calendarHeader));
        assert calendarHeader.isDisplayed();
    }
    public void clickOnAnalyzerButton() {
        analyzerButton.click();
    }
    public void isAnalyzerHeaderVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(analyzerHeader));
        assert analyzerHeader.isDisplayed();
    }
    public void clickPortfolio() {
        portfolioButton.click();
    }
    private void isPortfolioHeaderVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(portfolioHeader));
        assert portfolioHeader.isDisplayed();
    }
    private void clickAlertButton() {
        alertButton.click();
    }
    private void isAlertHeaderVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(alertHeader));
        assert alertHeader.isDisplayed();
    }
    private void clickEconomicDataButton() {
        economicDataButton.click();
    }
    private void isEconomicDataHeaderVisible() {
        driverWait.until(ExpectedConditions.visibilityOf(economicDataHeader));
        assert economicDataHeader.isDisplayed();
    }

}
