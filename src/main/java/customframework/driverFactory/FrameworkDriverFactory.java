package customframework.driverFactory;

public class FrameworkDriverFactory {

    public static BrowserDriver getDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                return new ChromeDriverManager();
            case "firefox":
                return new FirefoxDriverManager();
            default:
                throw new IllegalArgumentException("Browser type not supported");
        }
    }
}
