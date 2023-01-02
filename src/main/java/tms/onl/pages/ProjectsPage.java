package tms.onl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//div[@class='col-lg-12']/h1")
    private WebElement pageLabel;

    public String getProjectsPageLabel() {
        return pageLabel.getText();
    }
}
