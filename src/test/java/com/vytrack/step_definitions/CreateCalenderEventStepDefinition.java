package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCalenderEventPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CreateCalenderEventStepDefinition {

    CreateCalenderEventPage createCalenderEventPage = new CreateCalenderEventPage();

    @Given("user clicks on create calender event button")
    public void user_clicks_on_create_calender_event_button() {
createCalenderEventPage.clickOnEventBtn();

    }

    @When("user adds new calender event information")
    public void user_adds_new_calender_event_information(Map<String, String> dataTable) {
        dataTable.forEach((key, value) -> System.out.println("key: "+ key + "value: "+ value));

//        for (Map.Entry<String,String>entry: dataTable.entrySet()){
//            System.out.println("key "+ entry.getKey()+ ", value: "+entry.getValue());
//        }
        String title = dataTable.get("Title");
        String description = dataTable.get("Description");

        System.out.println("Title: "+ title );
        System.out.println("Description: "+ description );

        createCalenderEventPage.enterDescription(description);
        createCalenderEventPage.enterTitle(title);

    }

    @Then("user verifies that new calender event is isplayed:")
    public void user_verifies_that_new_calender_event_is_isplayed(Map<String, String> dataTable) {
        dataTable.forEach((key, value) -> System.out.println("key: "+ key + "value: "+ value));

        String title = dataTable.get("Title");
        String description = dataTable.get("Description");

        Assert.assertEquals(title, CreateCalenderEventPage.getDataFromGeneralInfo("Title"));
        Assert.assertEquals(description, CreateCalenderEventPage.getDataFromGeneralInfo("Description"));


    }
}
