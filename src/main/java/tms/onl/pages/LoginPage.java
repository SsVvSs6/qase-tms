package tms.onl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tms.onl.elements.inputs.LoginPageInput;
import tms.onl.utils.LoggerMessage;

public class LoginPage extends BasePage {

    private static final String LOGIN_PAGE_URL = "https://app.qase.io/login";
    private static final String EMAIL_ID = "inputEmail";
    private static final String PASSWORD_ID = "inputPassword";
    private static final String OPEN_PAGE_PROCESS_NAME = "Open login page";

    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='form-control-feedback']")
    private WebElement loginFieldErrorMessage;

    public LoginPage openPage() {
        LoggerMessage.logStartProcessInfo(OPEN_PAGE_PROCESS_NAME);
        driver.get(LOGIN_PAGE_URL);
        waitVisibilityOf(loginButton);
        LoggerMessage.logEndProcessInfo(OPEN_PAGE_PROCESS_NAME);
        return this;
    }
    public LoginPage fillInEmail(String text) {
        new LoginPageInput(EMAIL_ID).clearField().fillInField(text);
        return this;
    }

    public LoginPage fillInPassword(String text) {
        new LoginPageInput(PASSWORD_ID).clearField().fillInField(text);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoginFieldErrorMessage() {
        return loginFieldErrorMessage.getText();
    }
}
