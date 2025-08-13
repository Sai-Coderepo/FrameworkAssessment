package com.framework.tc.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/com/framework/tc/features/OrangeHRM",
        glue={"com.framework.tc.stepdefinitions","com.framework.tc.hooks"},
        tags="@ErrorloginFlow or @SuccessfulloginFlow",
        plugin={"pretty","html:test-output/ExecutionReport/AutomationReport.html"}
)
public class ParallelRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
