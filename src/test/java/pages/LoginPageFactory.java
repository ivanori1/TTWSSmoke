package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPageFactory {

    private WebDriver driver;
    private WebDriverWait driverWait;


    @FindBy(name = "userName")
    WebElement usernamePlaceholder;

    @FindBy(name = "password")
    WebElement passwordPlaceholder;

    @FindBy(id = "loginUser")
    WebElement loginButton;

    @FindBy(className = "error_container_inner")
    WebElement errorBox;

    @FindBy(xpath = "//*[@id='eulaAccepted']")
    WebElement eulaStatus;

    @FindBy(css = "[for='eulaAccepted'].checkBoxLabel")
    WebElement checkEula;

    @FindBy(id = "logo-ws")
    WebElement logoImg;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void sendKeysUsernamePlaceholder(String usernameStr) {
        usernamePlaceholder.clear();
        usernamePlaceholder.sendKeys(usernameStr);
    }

    public void sendKeysPasswordPlaceholder(String passwordStr) {
        passwordPlaceholder.clear();
        passwordPlaceholder.sendKeys(passwordStr);
    }

    public void compareErrorMessage(String errorMessage) {
        assert errorBox.getText().contains(errorMessage);
    }

    public void checkEula() {
        boolean eulaIsSelected = eulaStatus.isSelected();
        if (eulaIsSelected == false)
            checkEula.click();


    }
    public void isLogoVisible() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated((By) logoImg));
        assert logoImg.isDisplayed();
    }
}
