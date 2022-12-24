package tms.onl.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaseActionModalWindowPage extends BasePage {

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy (xpath = "//span[contains(text(),'Delete')]/ancestor::button[@type='button']")
    private WebElement deleteButton;

    public ProjectPage clickSubmitButton() {
        submitButton.click();
        return new ProjectPage();
    }

    public ProjectPage clickDeleteButton() {
        deleteButton.click();
        return new ProjectPage();
    }
}
