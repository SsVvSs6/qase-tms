package tms.onl.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tms.onl.model.User;
import tms.onl.services.LoginService;
import tms.onl.utils.Retry;

import static tms.onl.utils.StringConstant.*;

public class LoginPageTest extends BaseTest {

    private static final String INVALID_EMAIL = "ytrewq@qwerty.com";
    private static final String INVALID_PASSWORD = "sbft!65*";
    protected LoginService loginService;

    @BeforeClass
    public void setUp() {
        loginService = new LoginService();
        loginService.openPage();
    }

    @Test (description = "Successful authorization", priority = 1, retryAnalyzer = Retry.class, enabled = true)
    public void verifySuccessfulLoginTest() {
        String actualPageLabel = loginService.successfulLogin(User.builder()
                        .email(VALID_EMAIL)
                        .password(VALID_PASSWORD)
                        .build())
                .getProjectsPageLabel();
        String expectedPageLabel = "Projects";
        Assert.assertEquals(actualPageLabel, expectedPageLabel);
    }

    @Test (dataProvider = "Incorrect email or password set",
            description = "Unsuccessful authorization with incorrect password", retryAnalyzer = Retry.class,
            enabled = true)
    public void verifyInvalidPasswordTest(String email, String password) {
        String actualErrorText = loginService.unsuccessfulLogin(User.builder()
                        .email(email)
                        .password(password)
                        .build())
                .getLoginFieldErrorMessage();
        String expectedErrorText = "These credentials do not match our records.";
        Assert.assertEquals(actualErrorText, expectedErrorText);
    }

    @DataProvider(name = "Incorrect email or password set")
    private Object[][] incorrectEmailOrPasswordSet() {
        return new Object[][] {
                {VALID_EMAIL, INVALID_PASSWORD},
                {INVALID_EMAIL, VALID_PASSWORD},
                {INVALID_EMAIL, INVALID_PASSWORD}
        };
    }
}
