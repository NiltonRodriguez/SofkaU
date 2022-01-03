package co.com.sofka.page.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionsOnPages {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CommonActionsOnPages(WebDriver driver, int waitTime) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, waitTime);
    }

    // Functions
    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }
    protected void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }

    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }
    protected void clearText(WebElement webElement){
        webElement.clear();
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }
    protected void click(WebElement webElement){
        webElement.click();
    }

    protected void waitClick(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected void waitClick(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    protected void waitText(By locator, String text){
        wait.until(ExpectedConditions.textToBe(locator, text));
    }
    protected void waitText(WebElement webElement, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }
    
    protected void pressSpace(WebElement webElement){
        webElement.sendKeys(Keys.SPACE);
    }
    protected void waitSpace(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(Keys.SPACE);
    }

    protected void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
    protected void scrollTo(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", webElement);
    }

    protected void waitElement(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected  String getText (By locator){
        return driver.findElement(locator).getText();
    }
    protected String getText(WebElement webElement){
        return webElement.getText();
    }
}
