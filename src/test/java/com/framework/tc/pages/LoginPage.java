package com.framework.tc.pages;

import com.framework.tc.pageobjects.LoginPageObjects;
import customframework.externaldatahandlers.FilloUtils;
import customframework.runConfigurations.RunConfiguration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    public WebDriver driver;
    LoginPageObjects  loginPageObjects;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        loginPageObjects = PageFactory.initElements(driver, LoginPageObjects.class);
    }

    public void enterCredentials(String UserID)
    {try{
        FilloUtils fillo=new FilloUtils();
        fillo.getUserData(UserID);
        loginPageObjects.userName_txtbox.sendKeys(RunConfiguration.getInstance().bufferValues.get("UserName"));
        loginPageObjects.password_txtbox.sendKeys(RunConfiguration.getInstance().bufferValues.get("Password"));
    } catch (Exception e) {
        throw new RuntimeException(e);
    }}

    public void clickLoginButton()
        {
            try {
                loginPageObjects.login_btn.click();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    public void verifyInvalidUserMessage()
    {
        try {
           String actualMessage= loginPageObjects.invalidCredentials_errorMsg.getText();
           Assert.assertEquals(actualMessage,"Invalid credentials");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    }


