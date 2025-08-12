package com.framework.tc.stepdefinitions;

import com.framework.tc.pages.DashboardPage;
import com.framework.tc.pages.LoginPage;
import customframework.driverFactory.FrameworkDriverFactory;
import customframework.externaldatahandlers.PropertyFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDefinition {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public WebDriver driver = FrameworkDriverFactory.getDriver(PropertyFileReader.getConfigProperties("browser")).createDriver();

    public LoginPageStepDefinition() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Given("user launch the webapp")
    public void user_launch_the_webapp() {
        driver.get(PropertyFileReader.getConfigProperties("app_url"));
    }

    @When("user enter credentials for {string} user")
    public void user_enter_credentials_for_user(String userID) {
        loginPage.enterCredentials(userID);
    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user verify error message is displayed")
    public void user_verify_error_message_is_displayed() {
        loginPage.verifyInvalidUserMessage();
    }
}
