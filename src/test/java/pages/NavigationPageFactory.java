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
        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By) currenciesHeader));
        assert currenciesHeader.isDisplayed();
    }

    public void clickMarketButton() {
        marketButton.click();
    }

    public void isMarketHeaderVisible() {

        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By) marketHeader));
        assert marketHeader.isDisplayed();
    }

    public void clickFixedIncome() {

        fixedIncomeButton.click();
    }

    public void isFixedIncomeHeaderVisible() {

        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By) fixedIncomeHeader));
        assert fixedIncomeHeader.isDisplayed();
    }
}
