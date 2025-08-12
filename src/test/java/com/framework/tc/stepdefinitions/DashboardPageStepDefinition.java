package com.framework.tc.stepdefinitions;

import com.framework.tc.pages.DashboardPage;
import customframework.driverFactory.FrameworkDriverFactory;
import customframework.drivermanager.DriverManager;
import customframework.externaldatahandlers.PropertyFileReader;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class DashboardPageStepDefinition {

   public WebDriver driver = DriverManager.getDriver();
    DashboardPage dashboardPage;

    public DashboardPageStepDefinition() {
        dashboardPage = new DashboardPage( driver);
    }

    @Then("user verify dashboard page is displayed")
    public void user_verify_dashboard_page_is_displayed() {
        dashboardPage.verifyLandingPageTitle();
    }

    @Then("I logout of application")
    public void i_logout_of_application() {
        dashboardPage.logoutApplication();
    }
}
