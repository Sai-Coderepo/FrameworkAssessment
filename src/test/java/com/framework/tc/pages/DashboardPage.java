package com.framework.tc.pages;

import com.framework.tc.pageobjects.DashboardPageObjects;
import customframework.engine.UtilityFunctions;
import customframework.externaldatahandlers.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    DashboardPageObjects dashboardPageObjects;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        dashboardPageObjects = PageFactory.initElements(driver, DashboardPageObjects.class);
    }

    public void logoutApplication() {
        try {
            dashboardPageObjects.profile_dropdown.click();
            dashboardPageObjects.logout_txt.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyLandingPageTitle() {
        try {
            UtilityFunctions.waitForElement(driver,dashboardPageObjects.dashboardHeader_title, Duration.ofSeconds(Long.parseLong(PropertyFileReader.getTestExecutionProperties("explicitWait"))));
            String actualTitle = dashboardPageObjects.dashboardHeader_title.getText();
            Assert.assertEquals(actualTitle, "Dashboard");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
