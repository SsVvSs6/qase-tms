package tms.onl.ui.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tms.onl.ui.elements.inputs.LoginPageInput;

@Log4j2
public class LoginPage extends BasePage {

    private static final String LOGIN_PAGE_URL = "https://app.qase.io/login";
    private static final String EMAIL_ID = "inputEmail";
    private static final String PASSWORD_ID = "inputPassword";

    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement loginButton;

    public LoginPage openPage() {
        log.info("Open page starts");
        driver.get(LOGIN_PAGE_URL);
        waitVisibilityOf(loginButton);
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
}
