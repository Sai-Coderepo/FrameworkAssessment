package customframework.engine;

import customframework.driverFactory.FrameworkDriverFactory;
import customframework.drivermanager.DriverManager;
import customframework.externaldatahandlers.PropertyFileReader;
import customframework.runConfigurations.RunConfiguration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class UtilityFunctions {

    public WebDriver driver=null;
    public static void waitForElement(WebDriver driver, WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.withTimeout(timeout).pollingEvery(Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(element));

        }catch (Exception e){

        }
    }

    public WebDriver getDriver() {
        try {
            driver = FrameworkDriverFactory.getDriver(PropertyFileReader.getConfigProperties("browser")).createDriver();
            System.out.println(Thread.currentThread().getName()+" Driver Created");
        } catch (Exception e) {

        }
        return driver;
    }


    public WebDriver getDriver(String browser) {
        try {
            driver = FrameworkDriverFactory.getDriver(browser.toLowerCase()).createDriver();
            System.out.println(Thread.currentThread().getName()+" Driver Created");
        } catch (Exception e) {

        }
        return driver;
    }

    public static byte[] takeScreenShot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
