package tms.onl.services;

import io.qameta.allure.Step;
import tms.onl.model.Suite;
import tms.onl.pages.ProjectPage;
import tms.onl.utils.LoggerMessage;

public class ProjectService {

    private static final String CREATION_PROCESS_NAME = "Suite creation";
    private static final String EDITION_PROCESS_NAME = "Suite editing";
    private static final String CLONING_SUITE_PROCESS_NAME = "Suite cloning";
    private static final String DELETION_SUITE_PROCESS_NAME = "Suite deletion";
    private static final String OPEN_TEST_CASE_MODAL_WINDOW_PROCESS_NAME = "Open test case modal window";
    private static final String CLONING_TEST_CASE_PROCESS_NAME = "Case cloning";
    private static final String DELETION_TEST_CASE_PROCESS_NAME = "Case deletion";
    public ProjectPage openPage(String projectUrl) {
        return new ProjectPage().openPage(projectUrl);
    }

    @Step(CREATION_PROCESS_NAME)
    public ProjectPage createNewSuite(Suite suite) {
        LoggerMessage.logStartProcessInfo(CREATION_PROCESS_NAME);
        new ProjectPage().clickCreateSuiteButton()
                .fillInSuiteName(suite.getSuiteName())
                .fillInDescription(suite.getDescription())
                .fillInPreconditions(suite.getPreconditions())
                .clickSubmitButton();
        LoggerMessage.logEndProcessInfo(CREATION_PROCESS_NAME);
        return new ProjectPage();
    }

    public ProjectPage clickSuiteColumnButton() {
        return new ProjectPage().clickSuiteColumnButton();
    }

    @Step(EDITION_PROCESS_NAME)
    public ProjectPage editSuite(String suiteName, String newSuiteName) {
        LoggerMessage.logStartProcessInfo(EDITION_PROCESS_NAME);
        new ProjectPage().clickThreeDotsSuiteButton(suiteName)
                .clickEditSuiteButton()
                .fillInSuiteName(newSuiteName)
                .clickSubmitButton();
        LoggerMessage.logEndProcessInfo(EDITION_PROCESS_NAME);
        return new ProjectPage();
    }

    @Step(CLONING_SUITE_PROCESS_NAME)
    public ProjectPage cloneSuite(String suiteName) {
        LoggerMessage.logStartProcessInfo(CLONING_SUITE_PROCESS_NAME);
        new ProjectPage().clickThreeDotsSuiteButton(suiteName)
                .clickCloneSuiteButton()
                .clickSubmitButton();
        LoggerMessage.logEndProcessInfo(CLONING_SUITE_PROCESS_NAME);
        return new ProjectPage();
    }

    @Step(DELETION_SUITE_PROCESS_NAME)
    public ProjectPage deleteSuite(String suiteName) {
        LoggerMessage.logStartProcessInfo(DELETION_SUITE_PROCESS_NAME);
        new ProjectPage().clickThreeDotsSuiteButton(suiteName)
                .clickDeleteSuiteButton()
                .clickSubmitButton();
        LoggerMessage.logEndProcessInfo(DELETION_SUITE_PROCESS_NAME);
        return new ProjectPage();
    }

    @Step(OPEN_TEST_CASE_MODAL_WINDOW_PROCESS_NAME)
    public ProjectPage openTestCaseModalWindow(String testCaseName) {
        LoggerMessage.logStartProcessInfo(OPEN_TEST_CASE_MODAL_WINDOW_PROCESS_NAME);
        new ProjectPage().clickTestCaseMinusIcon(testCaseName);
        LoggerMessage.logEndProcessInfo(OPEN_TEST_CASE_MODAL_WINDOW_PROCESS_NAME);
        return new ProjectPage();
    }

    @Step(CLONING_TEST_CASE_PROCESS_NAME)
    public ProjectPage cloneTestCase(String testCaseName) {
        LoggerMessage.logStartProcessInfo(CLONING_TEST_CASE_PROCESS_NAME);
        openTestCaseModalWindow(testCaseName)
                .clickCloneTestCaseButton()
                .clickSubmitButton();
        LoggerMessage.logEndProcessInfo(CLONING_TEST_CASE_PROCESS_NAME);
        return new ProjectPage();
    }

    @Step(DELETION_TEST_CASE_PROCESS_NAME)
    public ProjectPage deleteTestCase(String testCaseName) {
        LoggerMessage.logStartProcessInfo(DELETION_TEST_CASE_PROCESS_NAME);
        openTestCaseModalWindow(testCaseName)
                .clickDeleteTestCaseButton()
                .clickDeleteButton();
        LoggerMessage.logEndProcessInfo(DELETION_TEST_CASE_PROCESS_NAME);
        return new ProjectPage();
    }

    public ProjectPage closeTestCaseModalWindow() {
        new ProjectPage().clickCloseTestCaseModalWindowButton();
        return new ProjectPage();
    }
}
