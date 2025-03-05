package com.wire.steps;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import wire.core.LaunchApp;

public class loginSteps {
    private static IOSDriver driver;

    @Given("user start the app")
    public static void launch(){
        LaunchApp.startApp();
    }

    @When("login with {string} and {string}")
    public void loginWithAnd(String username, String password) {
        // inspect username id and fill in username
        // inspect password id and fill in password
        // click on login button
    }

    @Then("login works correctly")
    public void loginWorksCorrectly() {
        // validate profile display name
    }
}
