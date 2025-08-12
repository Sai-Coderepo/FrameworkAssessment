package com.framework.tc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {

    @FindBy(name="username")
    public WebElement userName_txtbox;

    @FindBy(name="password")
    public WebElement password_txtbox;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement login_btn;

    @FindBy(xpath="//div[@class='orangehrm-login-forgot']/p")
    public WebElement forgotPassword_link;

    @FindBy(xpath="//div[@class='oxd-alert-content oxd-alert-content--error']")
    public WebElement invalidCredentials_errorMsg;
}
