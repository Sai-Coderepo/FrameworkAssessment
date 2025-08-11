package customframework.engine;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameworkReporter {

    String reporterFileName = "";
    public WebDriver FrameworkDriver;
    ExtentTest extentTest;
    ExtentSparkReporter sparkReporter;
    ExtentReports extent;

    public void getSparkReporter(String applicationName, String reportName) {
        reporterFileName = applicationName + "_TestEvidences_Report_" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()) + "_" + ".html";
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
        String folder = dateFormat.format(date);

        File dir = new File(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "ExecutionReport" + File.separator + folder);
        if (!dir.exists()) {
            dir.mkdir();
        }
        System.setProperty("ExecutionReportFolder", dir.getAbsolutePath());
        sparkReporter = new ExtentSparkReporter(System.getProperty("ExecutionReportFolder") + reporterFileName);
        sparkReporter.config().setReportName(applicationName);
        sparkReporter.config().setDocumentTitle("Execution Report");
        sparkReporter.config().thumbnailForBase64(true);
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("user.dir", System.getProperty("user.dir"));
    }


    public ExtentTest createTest(String testName) {
        extentTest = extent.createTest(testName);
        return extentTest;
    }

    public String screenshotBase64(WebDriver driver) {
        String base64Img = null;
        try {
            base64Img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return base64Img;
    }

    public void log(Status status, String scenarioName) {
        String screenshot = "";
        try {
            screenshot = screenshotBase64(FrameworkDriver);
            if (status.equals(Status.SKIP)) {
                createTest(scenarioName).log(Status.SKIP, "Test " + scenarioName + " has been skipped");
            } else if (status.equals(Status.FAIL)) {
                createTest(scenarioName).log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
            } else {
                createTest(scenarioName).log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
