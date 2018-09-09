package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    private WebDriver driver;

    @FindBy(name = "userName")
    WebElement usernamePlaceholder;

    @FindBy(name = "password")
    WebElement passwordPlaceholder;

    @FindBy(id = "loginUser")
    WebElement loginButton;

    @FindBy(className = "error_container_inner")
    WebElement errorBox;


    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void sendKeysUsernamePlaceholder(String usernameStr) {
        usernamePlaceholder.sendKeys(usernameStr);
    }

    public void sendKeysPasswordPlaceholder(String passwordStr) {
        passwordPlaceholder.sendKeys(passwordStr);
    }

    public void compareErrorMessage(String errorMessage) {
        assert errorBox.getText().contains(errorMessage);
    }
}
