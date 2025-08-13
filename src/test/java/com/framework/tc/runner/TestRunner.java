package com.framework.tc.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/com/framework/tc/features/OrangeHRM",
        glue={"com.framework.tc.stepdefinitions","com.framework.tc.hooks"},
        tags="@ErrorloginFlow or @SuccessfulloginFlow",
        plugin={"pretty","html:test-output/ExecutionReport/AutomationReport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
