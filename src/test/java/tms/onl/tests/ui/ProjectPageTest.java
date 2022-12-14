package tms.onl.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tms.onl.model.Suite;
import tms.onl.model.User;
import tms.onl.services.LoginService;
import tms.onl.services.ProjectService;
import tms.onl.utils.Retry;

import static tms.onl.utils.StringConstant.VALID_EMAIL;
import static tms.onl.utils.StringConstant.VALID_PASSWORD;

public class ProjectPageTest extends BaseTest {

    private final String creationSuiteName = "Any Name";
    private final String editSuiteName = "Any edited name";
    private final String testCaseName = "Test case";

    @BeforeClass (groups = "Short")
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

    @Test (description = "Collapse and expand suite column test", groups = "Short", retryAnalyzer = Retry.class,
            enabled = true)
    public void verifyCollapseAndExpandSuiteColumnTest() {
        boolean isSuiteColumnCollapsed = new ProjectService().clickSuiteColumnButton().isColumnLineDisplayed();
        boolean isSuiteColumnExpanded = new ProjectService().clickSuiteColumnButton().isColumnLineDisplayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(isSuiteColumnCollapsed);
        softAssert.assertTrue(isSuiteColumnExpanded);
        softAssert.assertAll();
    }

    @Test (description = "New suite creation", priority = 1, groups = "Short", retryAnalyzer = Retry.class,
            enabled = true)
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

    @Test (description = "Open test case modal window", priority = 5, retryAnalyzer = Retry.class, enabled = true)
    public void verifyTestCaseModalWindowIsOpenedTest() {
        boolean isTestCaseModalWindowOpened = new ProjectService().openTestCaseModalWindow(testCaseName)
                .isTestCaseModalWindowDisplayed();
        new ProjectService().closeTestCaseModalWindow();
        Assert.assertTrue(isTestCaseModalWindowOpened);
    }

    @Test (description = "Clone test case", priority = 6, retryAnalyzer = Retry.class, enabled = true)
    public void verifyCloneTestCaseTest() {
        boolean isCaseCloned = new ProjectService().cloneTestCase(testCaseName)
                .isSuccessfulCloneCaseMessageDisplayed();
        Assert.assertTrue(isCaseCloned);
    }

    @Test (description = "Delete test case", priority = 7, retryAnalyzer = Retry.class, enabled = true)
    public void verifyDeleteTestCaseTest() {
        boolean isCaseCloned = new ProjectService().deleteTestCase(testCaseName)
                .isSuccessfulDeleteCaseMessageDisplayed();
        Assert.assertTrue(isCaseCloned);
    }
}
