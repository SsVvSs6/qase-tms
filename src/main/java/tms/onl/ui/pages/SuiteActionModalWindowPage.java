package tms.onl.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tms.onl.ui.elements.inputs.SuiteModalWindowInput;

public class SuiteActionModalWindowPage extends BasePage {

    private static final String SUITE_NAME_ID = "name";

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy (xpath = "//div[@id='descriptionGroup']//div/p")
    private WebElement description;

    @FindBy (xpath = "//div[@id='preconditionsGroup']//div/p")
    private WebElement preconditions;

    public SuiteActionModalWindowPage fillInSuiteName(String text) {
        new SuiteModalWindowInput(SUITE_NAME_ID).clearField().fillInField(text);
        return this;
    }

    public SuiteActionModalWindowPage fillInDescription(String text) {
        description.clear();
        description.sendKeys(text);
        return this;
    }

    public SuiteActionModalWindowPage fillInPreconditions(String text) {
        preconditions.clear();
        preconditions.sendKeys(text);
        return this;
    }

    public ProjectPage clickSubmitButton() {
        submitButton.click();
        return new ProjectPage();
    }
}
