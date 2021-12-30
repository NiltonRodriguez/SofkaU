package co.com.sofka.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Utilities.defineOS;
import static co.com.sofka.util.Utilities.getUserDir;

public class WebUI {
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH_MAC = "src/test/resources/drivers/macOS/chrome/chromedriver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH_WINDOWS = "src/test/resources/drivers/macOS/chrome/chromedriver.exe";

    private static final String DESPEGAR_URL = "https://www.despegar.com.co/";

    protected WebDriver driver;

    private void setUpWebdriver(){
        if (defineOS().contains("Mac")){
            System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH_MAC);
        } else if (defineOS().contains("Windows")){
            System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH_WINDOWS);
        }
    }

    private void setUpWebdriverURL(){
        driver = new ChromeDriver();
        driver.get(DESPEGAR_URL);
    }

    private void setUpLog4j(){
        PropertyConfigurator.configure(getUserDir() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void generalSetUp(){
        setUpLog4j();
        setUpWebdriver();
        setUpWebdriverURL();
    }

    protected void quitDriver(){
        driver.quit();
    }
}
