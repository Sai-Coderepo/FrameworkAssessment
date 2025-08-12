package com.framework.tc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageObjects {

    @FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6")
    public WebElement dashboardHeader_title;

    @FindBy(xpath="//button[@type='button' and @role='none']/i[@class='oxd-icon bi-chevron-left']")
    public WebElement menuCollapse_button;

    @FindBy(xpath="//button[@type='button' and @role='none']/i[@class='oxd-icon bi-chevron-left']")
    public WebElement menuExpand_button;

    @FindBy(xpath="//button[@type='button' and @role='none']/i[@class='oxd-icon bi-chevron-left']")
    public WebElement profile_dropdown;

    @FindBy(linkText="Logout")
    public WebElement logout_txt;

}
