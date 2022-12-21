package tms.onl.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tms.onl.ui.model.Suite;
import tms.onl.ui.model.User;
import tms.onl.ui.services.LoginService;
import tms.onl.ui.services.ProjectService;
import tms.onl.utils.Retry;

import static tms.onl.utils.StringConstant.VALID_EMAIL;
import static tms.onl.utils.StringConstant.VALID_PASSWORD;

public class ProjectPageTest extends BaseTest {

    private final String creationSuiteName = "Any Name";
    private final String editSuiteName = "Any edited name";

    @BeforeClass
    public void login() {
        LoginService loginService = new LoginService();
        loginService.openPage();
        loginService.successfulLogin(User.builder()
                .email(VALID_EMAIL)
                .password(VALID_PASSWORD)
                .build());
        String projectUrl = "https://app.qase.io/project/QTQ";
        new ProjectService().openPage(projectUrl);
    }

    @Test (description = "Collapse and expand suite column test", retryAnalyzer = Retry.class, enabled = true)
    public void verifyCollapseAndExpandSuiteColumnTest() {
        boolean isSuiteColumnCollapsed = new ProjectService().clickSuiteColumnButton().isColumnLineDisplayed();
        boolean isSuiteColumnExpanded = new ProjectService().clickSuiteColumnButton().isColumnLineDisplayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(isSuiteColumnCollapsed);
        softAssert.assertTrue(isSuiteColumnExpanded);
        softAssert.assertAll();
    }

    @Test (description = "New suite creation", priority = 1, retryAnalyzer = Retry.class, enabled = true)
    public void verifyCreateNewSuiteTest() {
        String suitePrecondition = "Preconditions";
        String suiteDescription = "Description";
        Suite suite = Suite.builder()
                .suiteName(creationSuiteName)
                .description(suiteDescription)
                .preconditions(suitePrecondition)
                .build();
        boolean isCreationSuccessful = new ProjectService().createNewSuite(suite)
                .isSuccessfulCreateSuiteMessageDisplayed();
        Assert.assertTrue(isCreationSuccessful);
    }

    @Test (description = "Clone suite", priority = 2, retryAnalyzer = Retry.class, enabled = true)
    public void verifyCloneSuiteTest() {
        boolean isClonedSuccessful = new ProjectService().cloneSuite(creationSuiteName)
                .isSuccessfulCloneSuiteMessageDisplayed();
        Assert.assertTrue(isClonedSuccessful);
    }

    @Test (description = "Edit suite", priority = 3, retryAnalyzer = Retry.class, enabled = true)
    public void verifyEditSuiteTest() {
        boolean isEditionSuccessful = new ProjectService().editSuite(creationSuiteName, editSuiteName)
                .isSuccessfulEditSuiteMessageDisplayed();
        Assert.assertTrue(isEditionSuccessful);
    }

    @Test (description = "Delete suite", priority = 4, retryAnalyzer = Retry.class, enabled = true)
    public void verifyDeleteSuiteTest() {
        boolean isDeletionSuccessful = new ProjectService().deleteSuite(editSuiteName)
                .isSuccessfulDeleteSuiteMessageDisplayed();
        Assert.assertTrue(isDeletionSuccessful);
    }
}
