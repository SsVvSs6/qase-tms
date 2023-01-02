package tms.onl.ui.services;

import io.qameta.allure.Step;
import tms.onl.ui.model.User;
import tms.onl.ui.pages.LoginPage;
import tms.onl.ui.pages.ProjectsPage;
import tms.onl.ui.utils.LoggerMessage;

public class LoginService {

    private static final String LOGIN_PROCESS_NAME = "Login";
    private LoginPage loginPage = new LoginPage();

    public LoginPage openPage() {
        return loginPage.openPage();
    }
    public ProjectsPage successfulLogin(User user) {
        login(user);
        return new ProjectsPage();
    }

    public LoginPage unsuccessfulLogin(User user) {
        login(user);
        return new LoginPage();
    }

    @Step(LOGIN_PROCESS_NAME)
    private void login(User user) {
        LoggerMessage.logStartProcessInfo(LOGIN_PROCESS_NAME);
        loginPage.fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickLoginButton();
        LoggerMessage.logEndProcessInfo(LOGIN_PROCESS_NAME);
    }
}
