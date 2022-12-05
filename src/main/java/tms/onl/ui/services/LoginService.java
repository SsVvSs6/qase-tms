package tms.onl.ui.services;

import lombok.extern.log4j.Log4j2;
import tms.onl.ui.model.User;
import tms.onl.ui.pages.LoginPage;
import tms.onl.ui.pages.ProjectsPage;

@Log4j2
public class LoginService {

    private LoginPage loginPage = new LoginPage();

    public ProjectsPage successfulLogin(User user) {
        login(user);
        return new ProjectsPage();
    }

    public LoginPage unsuccessfulLogin(User user) {
        login(user);
        return new LoginPage();
    }

    private void login(User user) {
        log.info("Login start");
        loginPage.openPage()
                .fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickLoginButton();
        log.info("Login ends");
    }
}
