package tms.onl.utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import tms.onl.pages.BasePage;

public class TryCatchMethods {

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return BasePage.waitVisibilityOf(element).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
