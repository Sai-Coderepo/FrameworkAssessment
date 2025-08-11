package customframework.driverFactory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.List;

public class FirefoxDriverManager implements BrowserDriver {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        List<String> arguments = new ArrayList<String>();
        arguments.add("start-maximized");
        arguments.add("--ignore-certificate-errors");
        arguments.add("allow-running-insecure-content");
        firefoxOptions.addArguments(arguments);
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        return firefoxDriver;
    }
}
