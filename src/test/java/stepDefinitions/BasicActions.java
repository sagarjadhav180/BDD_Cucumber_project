package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasicActionPage;
import pages.GooglePage;
import utils.CommonUtils;

public class BasicActions {

    BasicActionPage basicActionPage = new BasicActionPage();


    @When("I open practise page")
    public void iOpenPractisePage() {
        basicActionPage.openPractisePage();
    }

    @Then("Practise page should be displayed")
    public void practisePageShouldBeDisplayed() {
        basicActionPage.practicePageLabel();
    }

    @When("I click on {string} button")
    public void iClickOnButton(String button) {

    }

    @Then("{string} button should be checked")
    public void buttonShouldBeChecked(String button) {
        basicActionPage.checkIfRadioButtonClicked(button);
    }

    @When("I scroll down to Mouse Hover")
    public void iScrollDownToMouseHover() {
        basicActionPage.scrollToMouseHoverButton();
    }

    @Then("Mouse Hover button should be displayed on screen")
    public void mouseHoverButtonShouldBeDisplayedOnScreen() {
        basicActionPage.mouseHoverButton();
    }

    @When("I click on {string} Radio button")
    public void iClickOnRadioButton(String button) {
        basicActionPage.clickOnRadioButton(button);
    }

    @When("I click on {string} button with javascriptexecutor")
    public void iClickOnButtonWithJavascriptexecutor(String button) {
        basicActionPage.jsClickOnButton(button);
    }

    @Then("Login button should be displayed")
    public void loginButtonShouldBeDisplayed() {
        basicActionPage.loginButtonDisplayed();
    }
}
