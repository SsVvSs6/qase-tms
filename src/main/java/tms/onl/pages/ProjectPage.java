package tms.onl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tms.onl.utils.LoggerMessage;
import tms.onl.utils.TryCatchMethods;

public class ProjectPage extends BasePage {

    private static final String SUITE_BUTTON_X_PATH = "//div[contains(text(),'%s')]";
    private static final String EDIT_SUITE_BUTTON_NAME = "Edit";
    private static final String CLONE_SUITE_BUTTON_NAME = "Clone";
    private static final String DELETE_SUITE_BUTTON_NAME = "Delete";
    private static final String SUITE_COLUMN_LINE_X_PATH = "//span[@class='Resizer vertical ']";
    private static final String SUITES_THREE_DOTS_X_PATH =
            "//a[@title='%s']/ancestor::div[contains(@class,'CQWegX')]//i[@class='fa fa-ellipsis-h']";
    private static final String TEST_CASE_MINUS_ICON_X_PATH =
            "//div[contains(text(),'%s')]/ancestor::div[contains(@class,'F8M2Vb')]//i[contains(@class,'minus')]";
    private static final String TEST_CASE_BUTTON_X_PATH = "//span[contains(text(),'%s')]/ancestor::button";
    private static final String CLONE_BUTTON_TEXT = "Clone";
    private static final String DELETE_BUTTON_TEXT = "Delete";
    private static final String OPEN_PAGE_PROCESS_NAME = "Open project page";
    @FindBy (xpath = "//a[@id='create-suite-button']")
    private WebElement createSuiteButton;

    @FindBy (xpath = "//button/i[@class='far fa-stream']")
    private WebElement suitesColumnButton;

    @FindBy (xpath = "//span[contains(text(),'Suite was successfully created.')]")
    private WebElement successfulCreateSuiteMessage;

    @FindBy (xpath = "//span[contains(text(),'Suite was successfully cloned')]")
    private WebElement successfulCloneSuiteMessage;

    @FindBy (xpath = "//span[contains(text(),'Suite was successfully edited.')]")
    private WebElement successfulEditSuiteMessage;

    @FindBy (xpath = "//span[contains(text(),'Suite was successfully deleted.')]")
    private WebElement successfulDeleteSuiteMessage;

    @FindBy (xpath = "//span[contains(text(),'Case was successfully cloned')]")
    private WebElement successfulCloneCaseMessage;

    @FindBy (xpath = "//span[contains(text(),'was successfully deleted')]")
    private WebElement successfulDeleteCaseMessage;

    @FindBy (xpath = "//div[contains(@class,'daLejL')]")
    private WebElement testCaseModalWindow;

    @FindBy (xpath = "//button[contains(@class,'kUdMAa')]/i[contains(@class,'right')]")
    private WebElement testCaseRightButton;

    @FindBy (xpath = "//button[@class='hhg1oh']")
    private WebElement closeTestCaseModalWindowButton;

    public ProjectPage openPage(String projectUrl) {
        LoggerMessage.logStartProcessInfo(OPEN_PAGE_PROCESS_NAME);
        driver.get(projectUrl);
        waitVisibilityOf(createSuiteButton);
        LoggerMessage.logEndProcessInfo(OPEN_PAGE_PROCESS_NAME);
        return this;
    }

    public SuiteActionModalWindowPage clickCreateSuiteButton() {
        createSuiteButton.click();
        return new SuiteActionModalWindowPage();
    }

    public ProjectPage clickSuiteColumnButton() {
        suitesColumnButton.click();
        return this;
    }

    public ProjectPage clickThreeDotsSuiteButton(String suiteName) {
        clickButtonWithStringFormat(SUITES_THREE_DOTS_X_PATH, suiteName);
        return this;
    }

    public SuiteActionModalWindowPage clickEditSuiteButton() {
        clickButtonWithStringFormat(SUITE_BUTTON_X_PATH, EDIT_SUITE_BUTTON_NAME);
        return new SuiteActionModalWindowPage();
    }

    public SuiteActionModalWindowPage clickCloneSuiteButton() {
        clickButtonWithStringFormat(SUITE_BUTTON_X_PATH, CLONE_SUITE_BUTTON_NAME);
        return new SuiteActionModalWindowPage();
    }

    public SuiteActionModalWindowPage clickDeleteSuiteButton() {
        clickButtonWithStringFormat(SUITE_BUTTON_X_PATH, DELETE_SUITE_BUTTON_NAME);
        return new SuiteActionModalWindowPage();
    }

    public ProjectPage clickTestCaseMinusIcon(String testCaseName) {
        clickButtonWithStringFormat(TEST_CASE_MINUS_ICON_X_PATH, testCaseName);
        waitVisibilityOf(testCaseRightButton);
        return this;
    }

    public CaseActionModalWindowPage clickCloneTestCaseButton() {
        clickButtonWithStringFormat(TEST_CASE_BUTTON_X_PATH, CLONE_BUTTON_TEXT);
        return new CaseActionModalWindowPage();
    }

    public CaseActionModalWindowPage clickDeleteTestCaseButton() {
        clickButtonWithStringFormat(TEST_CASE_BUTTON_X_PATH, DELETE_BUTTON_TEXT);
        return new CaseActionModalWindowPage();
    }

    public ProjectsPage clickCloseTestCaseModalWindowButton() {
        closeTestCaseModalWindowButton.click();
        return new ProjectsPage();
    }

    public boolean isTestCaseModalWindowDisplayed() {
        return TryCatchMethods.isElementDisplayed(testCaseModalWindow);
    }

    public boolean isSuccessfulCreateSuiteMessageDisplayed() {
        return isMessageDisplayed(successfulCreateSuiteMessage);
    }

    public boolean isSuccessfulCloneSuiteMessageDisplayed() {
        return isMessageDisplayed(successfulCloneSuiteMessage);
    }

    public boolean isSuccessfulEditSuiteMessageDisplayed() {
        return isMessageDisplayed(successfulEditSuiteMessage);
    }

    public boolean isSuccessfulDeleteSuiteMessageDisplayed() {
        return isMessageDisplayed(successfulDeleteSuiteMessage);
    }

    public boolean isSuccessfulCloneCaseMessageDisplayed() {
        return isMessageDisplayed(successfulCloneCaseMessage);
    }

    public boolean isSuccessfulDeleteCaseMessageDisplayed() {
        return isMessageDisplayed(successfulDeleteCaseMessage);
    }

    public boolean isColumnLineDisplayed() {
        return driver.findElements(By.xpath(SUITE_COLUMN_LINE_X_PATH)).size() != 0;
    }

    private boolean isMessageDisplayed(WebElement element) {
        return TryCatchMethods.isElementDisplayed(element);
    }

    private void clickButtonWithStringFormat(String mainXPath, String sPart) {
        driver.findElement(By.xpath(String.format(mainXPath, sPart))).click();
    }
}
