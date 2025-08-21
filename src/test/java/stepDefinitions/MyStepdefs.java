package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GooglePage;
import utils.DriverFactory;

public class MyStepdefs {


    private DriverFactory driverFactory;
    private GooglePage googlePage;

    public MyStepdefs(){
        this.driverFactory = new DriverFactory();
        this.googlePage = new GooglePage(driverFactory.driver);
    }



    @Given("I open Google page")
    public void i_open_the_google_page() {
        googlePage.openGooglePage();

    }

    @When("I search for {string}")
    public void iSearchFor(String searchText) {
        googlePage.enterTextInSearchBox(searchText);
    }

    @Then("I Select {string} option from the displayed options")
    public void iSelectOptionFromTheDisplayedOptions(String optionToSelect) {
        googlePage.selectOption(optionToSelect);
    }



}
