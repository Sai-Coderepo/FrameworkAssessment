package com.framework.tc.stepdefinitions;

import com.framework.tc.pages.DashboardPage;
import com.framework.tc.pages.LoginPage;
import customframework.driverFactory.FrameworkDriverFactory;
import customframework.externaldatahandlers.PropertyFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDefinition {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PropertyFileReader udpreader;
    public WebDriver driver;

    public LoginPageStepDefinition() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Given("user launch the webapp")
    public void user_launch_the_webapp() {
        driver = FrameworkDriverFactory.getDriver(PropertyFileReader.getConfigProperties("browser")).createDriver();
        driver.get(PropertyFileReader.getConfigProperties("app_url"));
        driver.quit();
    }

    @When("user enter credentials for {string} user")
    public void user_enter_credentials_for_user(String string) {
        
    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
