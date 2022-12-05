package tms.onl.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tms.onl.ui.model.User;
import tms.onl.ui.services.LoginService;
import tms.onl.utils.Retry;

public class LoginPageTest extends BaseTest {

    protected LoginService loginService;
    private static final String VALID_EMAIL = "pemawes802@diratu.com";
    private static final String VALID_PASSWORD = "Dbft!65*";
    protected User user;

    @BeforeClass
    public void setUp() {
        loginService = new LoginService();
    }

    @Test (description = "Successful authorization", retryAnalyzer = Retry.class)
    public void verifySuccessfulLoginTest() {
        user = User.builder()
                .email(VALID_EMAIL)
                .password(VALID_PASSWORD)
                .build();
        String actualPageLabel = loginService.successfulLogin(user)
                .getProjectsPageLabel();
        String expectedPageLabel = "Projects";
        Assert.assertEquals(actualPageLabel, expectedPageLabel);
    }
}
