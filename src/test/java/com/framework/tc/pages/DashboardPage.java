package com.framework.tc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;
    public DashboardPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

}
