package co.com.sofka.page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void waitClick(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void waitText(By locator, String text){
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pressRightArrow(By locator){
        driver.findElement(locator).sendKeys(Keys.ARROW_RIGHT);
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected  String getText (By locator){
        return driver.findElement(locator).getText();
    }
}
