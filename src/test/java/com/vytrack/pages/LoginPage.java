package com.vytrack.pages;

import com.vytrack.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    // to not use web element directly in step definition
    // helps to prvent code duplication and keep step definition clean

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return warningMessage.getText().trim();
    }

    public void login(String usernamevalue, String passwordvalue){
        username.sendKeys(usernamevalue);
        password.sendKeys(passwordvalue, Keys.ENTER);
    }

    public void login(){

        String usernamevalue = ConfigurationReader.getProperty("storemanager.username");
        String passwordvalue = ConfigurationReader.getProperty("password");

        username.sendKeys(usernamevalue);
        password.sendKeys(passwordvalue, Keys.ENTER);
    }

    public void login(String role){

        String usernamevalue = "";
        String passwordvalue = ConfigurationReader.getProperty("password");

        if (role.equalsIgnoreCase("sales manager")){
            usernamevalue = ConfigurationReader.getProperty("salesmanager.username");
        }else if (role.equalsIgnoreCase("driver")){
            usernamevalue = ConfigurationReader.getProperty("driver.username");
        }else {
            usernamevalue = ConfigurationReader.getProperty("storemanager.username");
        }

        username.sendKeys(usernamevalue);
        password.sendKeys(passwordvalue, Keys.ENTER);
    }


}
