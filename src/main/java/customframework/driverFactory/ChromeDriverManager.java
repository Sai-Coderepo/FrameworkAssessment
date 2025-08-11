package customframework.driverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class ChromeDriverManager implements BrowserDriver {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        List<String> arguments = new ArrayList<String>();
        arguments.add("--ignore-certificate-errors");
        arguments.add("start-maximized");
        arguments.add("allow-running-insecure-content");
        chromeOptions.addArguments(arguments);
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        return chromeDriver;
    }
}
