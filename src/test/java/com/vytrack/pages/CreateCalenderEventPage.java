package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCalenderEventPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalenderBtn;

    @FindBy(xpath = "//*[@name='oro_calendar_event_form[title]']")
    private WebElement titleInputBox;

    @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;


    public void clickOnEventBtn(){
        BrowserUtils.clickOnElement(createCalenderBtn);
        System.out.println("Clicking on 'Create Event' Button");
    }

    public void enterDescription(String description){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        Driver.getDriver().switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
       // BrowserUtils.enterText(descriptionInputBox,description);
        descriptionInputBox.sendKeys(description);
        Driver.getDriver().switchTo().defaultContent();

    }

    public void enterTitle(String title){
        BrowserUtils.enterText(titleInputBox,title);
    }

  public static String getDataFromGeneralInfo(String parameterName){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        String xpath = "//label[text()='" + parameterName + "']/../div/div";
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();

  }

}
