package tms.onl.ui.services;

import io.qameta.allure.Step;
import tms.onl.ui.model.Suite;
import tms.onl.ui.pages.ProjectPage;
import tms.onl.ui.utils.LoggerMessage;

public class ProjectService {

    private static final String CREATION_PROCESS_NAME = "Suite creation";
    private static final String EDITION_PROCESS_NAME = "Suite editing";
    private static final String CLONING_PROCESS_NAME = "Suite cloning";
    private static final String DELETION_PROCESS_NAME = "Suite deletion";
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

    @Step(CLONING_PROCESS_NAME)
    public ProjectPage cloneSuite(String suiteName) {
        LoggerMessage.logStartProcessInfo(CLONING_PROCESS_NAME);
        new ProjectPage().clickThreeDotsSuiteButton(suiteName)
                .clickCloneSuiteButton()
                .clickSubmitButton();
        LoggerMessage.logEndProcessInfo(CLONING_PROCESS_NAME);
        return new ProjectPage();
    }

    @Step(DELETION_PROCESS_NAME)
    public ProjectPage deleteSuite(String suiteName) {
        LoggerMessage.logStartProcessInfo(DELETION_PROCESS_NAME);
        new ProjectPage().clickThreeDotsSuiteButton(suiteName)
                .clickDeleteSuiteButton()
                .clickSubmitButton();
        LoggerMessage.logEndProcessInfo(DELETION_PROCESS_NAME);
        return new ProjectPage();
    }
}
