package customframework.driverFactory;
import customframework.externaldatahandlers.PropertyFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ChromeDriverManager implements BrowserDriver {

    private static String driverPath = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver.exe";
    @Override
    public WebDriver createDriver() {

       // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        List<String> arguments = new ArrayList<String>();
        arguments.add("--ignore-certificate-errors");
        arguments.add("start-maximized");
        arguments.add("allow-running-insecure-content");
        chromeOptions.addArguments(arguments);
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(PropertyFileReader.getTestExecutionProperties("implicitWait"))));
        return chromeDriver;
    }
}
