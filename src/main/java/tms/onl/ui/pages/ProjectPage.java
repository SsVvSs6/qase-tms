package tms.onl.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tms.onl.ui.utils.LoggerMessage;

public class ProjectPage extends BasePage {

    @FindBy (xpath = "//a[@id='create-suite-button']")
    private WebElement createSuiteButton;

    @FindBy (xpath = "//button/i[@class='far fa-stream']")
    private WebElement suitesColumnButton;

    @FindBy (xpath = "//span[@class='Resizer vertical ']")
    private WebElement suitesColumnLine;

    @FindBy (xpath = "//div[contains(text(),'Edit')]")
    private WebElement editSuiteButton;

    @FindBy (xpath = "//div[contains(text(),'Delete')]")
    private WebElement deleteSuiteButton;

    @FindBy (xpath = "//div[contains(text(),'Clone')]")
    private WebElement cloneSuiteButton;

    @FindBy (xpath = "//span[contains(text(),'Suite was successfully created.')]")
    private WebElement successfulCreateSuiteMessage;

    @FindBy (xpath = "//span[contains(text(),'Suite was successfully cloned')]")
    private WebElement successfulCloneSuiteMessage;

    @FindBy (xpath = "//span[contains(text(),'Suite was successfully edited.')]")
    private WebElement successfulEditSuiteMessage;

    @FindBy (xpath = "//span[contains(text(),'Suite was successfully deleted.')]")
    private WebElement successfulDeleteSuiteMessage;

    private static final String SUITE_COLUMN_LINE_X_PATH = "//span[@class='Resizer vertical ']";
    private static final String SUITES_THREE_DOTS_X_PATH =
            "//a[@title='%s']/ancestor::div[contains(@class,'CQWegX')]//i[@class='fa fa-ellipsis-h']";
    private static final String OPEN_PAGE_PROCESS_NAME = "Open project page";

    public ProjectPage openPage(String projectUrl) {
        LoggerMessage.logStartProcessInfo(OPEN_PAGE_PROCESS_NAME);
        driver.get(projectUrl);
        waitVisibilityOf(createSuiteButton);
        LoggerMessage.logEndProcessInfo(OPEN_PAGE_PROCESS_NAME);
        return this;
    }

    public SuiteModalWindowPage clickCreateSuiteButton() {
        createSuiteButton.click();
        return new SuiteModalWindowPage();
    }

    public ProjectPage clickSuiteColumnButton() {
        suitesColumnButton.click();
        return this;
    }

    public ProjectPage clickThreeDotsSuiteButton(String suiteName) {
        driver.findElement(By.xpath(String.format(SUITES_THREE_DOTS_X_PATH, suiteName))).click();
        return this;
    }

    public SuiteModalWindowPage clickEditSuiteButton() {
        editSuiteButton.click();
        return new SuiteModalWindowPage();
    }

    public SuiteModalWindowPage clickCloneSuiteButton() {
        cloneSuiteButton.click();
        return new SuiteModalWindowPage();
    }

    public SuiteModalWindowPage clickDeleteSuiteButton() {
        deleteSuiteButton.click();
        return new SuiteModalWindowPage();
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

    public boolean isColumnLineDisplayed() {
        return driver.findElements(By.xpath(SUITE_COLUMN_LINE_X_PATH)).size() != 0;
    }

    private boolean isMessageDisplayed(WebElement element) {
        return waitVisibilityOf(element).isDisplayed();
    }
}
