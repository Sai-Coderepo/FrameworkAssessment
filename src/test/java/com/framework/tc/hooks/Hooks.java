package com.framework.tc.hooks;

import customframework.drivermanager.DriverManager;
import customframework.engine.UtilityFunctions;
import customframework.runConfigurations.RunConfiguration;
import io.cucumber.java.After;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Hooks {
    @Before(order = -9999)
    public void setup() {
        try {
            RunConfiguration.getInstance().frameworkDriver = new UtilityFunctions().getDriver();
            DriverManager.setDriver(RunConfiguration.getInstance().frameworkDriver);
        } catch (Exception e) {

        }
    }


    @After(order = 9999)
    public void teardown() {
        try {
            DriverManager.removeDriver();
        } catch (Exception e) {

        }
    }
}
