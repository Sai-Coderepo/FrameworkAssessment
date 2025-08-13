package customframework.runConfigurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import customframework.engine.FrameworkReporter;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class RunConfiguration {

    public static RunConfiguration runConfiguration;
    public ExtentReports extent = null;
    public ExtentTest test = null;
    public ExtentSparkReporter sparkReporter = null;
    public FrameworkReporter frameworkReporter = null;
    public Map<String, String> mapExecutionProperties = null;
    public Map<String, String> bufferValues = null;
    public WebDriver frameworkDriver = null;

    private RunConfiguration() {
        frameworkReporter = new FrameworkReporter();
        mapExecutionProperties = new HashMap<>();
        bufferValues = new HashMap<>();
    }

    public static RunConfiguration getInstance() {
        if (runConfiguration == null) {
            runConfiguration = new RunConfiguration();
        }
        return runConfiguration;
    }
}

