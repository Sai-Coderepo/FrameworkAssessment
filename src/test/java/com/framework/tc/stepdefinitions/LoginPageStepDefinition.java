package com.framework.tc.stepdefinitions;

import com.framework.tc.pages.DashboardPage;
import com.framework.tc.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDefinition {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public WebDriver driver;

    public LoginPageStepDefinition() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

}
