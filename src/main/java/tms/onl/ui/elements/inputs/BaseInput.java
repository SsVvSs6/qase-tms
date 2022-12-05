package tms.onl.ui.elements.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tms.onl.ui.driver.DriverSingleton;

import java.time.Duration;

public abstract class BaseInput {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    private static final int WAITING_OF_SECONDS = 15;

    protected void writeText(String text, String xPath) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_OF_SECONDS))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(xPath)))
                .sendKeys(text);
    }

    protected void clearField(String xPath) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_OF_SECONDS))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(xPath)))
                .clear();
    }
}