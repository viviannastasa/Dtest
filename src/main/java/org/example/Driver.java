package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }

    public static void click(By element) {
        getDriver().findElement(element).click();
    }

    public static void typeText(By element, String text) {
        getDriver().findElement(element).clear();
        getDriver().findElement(element).sendKeys(text);
    }

    public static void assertIsDisplayed(By element, String errorMessage) {
        Assert.isTrue(getDriver().findElement(element).isDisplayed(), errorMessage);
    }

    public static void select(By dropdownElement, String optionText) {
        click(dropdownElement);
        Select dropdown = new Select(driver.findElement(dropdownElement));
        dropdown.selectByVisibleText(optionText);
    }

    public static WebElement fluentWaitForElement(By element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void clickToRightByOffset(By element, int offsetPixels) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getDriver().findElement(element));
        actions.moveByOffset(offsetPixels, 20);
        actions.click().build().perform();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
