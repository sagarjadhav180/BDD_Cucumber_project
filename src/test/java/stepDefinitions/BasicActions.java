package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasicActionPage;
import pages.GooglePage;

public class BasicActions {

    BasicActionPage basicActionPage = new BasicActionPage();


    @When("I open practise page")
    public void iOpenPractisePage() {

    }

    @Then("Practise page should be displayed")
    public void practisePageShouldBeDisplayed() {
        basicActionPage.openPractisePage();
    }

    @When("I click on {string} button")
    public void iClickOnButton(String button) {
        basicActionPage.clickOnRadioButton(button);
    }
}
