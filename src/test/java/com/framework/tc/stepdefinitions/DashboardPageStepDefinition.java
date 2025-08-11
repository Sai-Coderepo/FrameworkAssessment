package com.framework.tc.stepdefinitions;

import com.framework.tc.pages.DashboardPage;
import org.openqa.selenium.WebDriver;

public class DashboardPageStepDefinition {

    WebDriver driver;
    DashboardPage dashboardPage;

    public DashboardPageStepDefinition() {
        dashboardPage = new DashboardPage( driver);
    }

}
