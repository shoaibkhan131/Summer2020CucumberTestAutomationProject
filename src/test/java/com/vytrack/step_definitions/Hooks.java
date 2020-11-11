package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {


    // class that contain setup and teardown methods.
/*
for example : suite setup and teardown
Hokos triggered based on tags not class name or their location
these methods can be a part of any step definition class
common practice is to store them in seprate class.
 */

    // hook before = @BeforeMethod in TestNG
    // hook after = @AfterMethod in TestNG
    // it is not a good idea to mix implicit and explicit wait. it can lead to unexpected

    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println("::: Starting Automation :::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    //this hook will run only before the scenarios with the following tag "@db"
    @Before(value = "@db", order = 0)
    public void dbSetup(){
        System.out.println("::: Connecting to the database :::");
    }

    @After("@db")
    public void dbTearDown(){
        System.out.println("::: Disconnecting to the Database :::");
    }

    @After
    public void tearDown(){

        // this is a Hook After
        // runs automatically after every test regardless of test status whether test fail or pass.
        Driver.closeDriver();
        System.out.println("::: End of test execution :::");
    }
}
