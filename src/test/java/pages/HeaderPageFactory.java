package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPageFactory {
    WebDriver driver;
    WebDriverWait driverWait;

    @FindBy(id = "logo-ws")
    WebElement logoImg;

    @FindBy(id = "user-button")
    WebElement userButton;

    @FindBy(css = "[href='Logout.aspx']")
    WebElement logout;
    @FindBy(id = "loginUser")
    WebElement loginButton;

    public HeaderPageFactory(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void isLogoVisible() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo-ws")));
        assert logoImg.isDisplayed();
    }

    public void clickUserButton() {
        userButton.click();
    }

    public void clickLogout() {
        logout.click();
    }
}
