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
        PageFactory.initElements(driver, this);
    }

    public void isLogoVisible() {
        assert logoImg.isDisplayed();
    }

    public void clickUserButton() {
        userButton.click();
    }

    public void clickLogout() {
        logout.click();
    }
}
