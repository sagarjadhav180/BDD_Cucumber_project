package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BasicActionPage;
import pages.GooglePage;
import utils.CommonUtils;
import utils.DriverFactory;

public class BasicActions {

    private DriverFactory driverFactory;
    private BasicActionPage basicActionPage;

    public BasicActions(DriverFactory driverFactory){
        this.driverFactory = driverFactory;
        basicActionPage = new BasicActionPage(this.driverFactory.driver);

    }



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

    @When("I Enter {string} in suggestion class example box")
    public void iEnterInSuggestionClassExampleBox(String country) {
        basicActionPage.enterCountryInAutoSuggestionBox(country);
    }

    @Then("{string} should be displayed in the list")
    public void shouldBeDisplayedInTheList(String country) {
        basicActionPage.isEnteredCountryPresentInTheList(country);
    }

    @When("I click on {string} option")
    public void iClickOnOption(String country) {
        basicActionPage.selectCountrydisplayedInTheList(country);
    }

    @Then("Country {string} should be selected in listbox")
    public void countryShouldBeSelectedInListbox(String country) {
    }

    @When("I select {string} from dropdown")
    public void iSelectFromDropdown(String option) {
        basicActionPage.selectOptionFromDropDown(option);
    }

    @Then("Selected option {string} should be displayed")
    public void selectedOptionShouldBeDisplayed(String option) {
        basicActionPage.verifyIfOptionSelected(option);
    }

    @When("I select checkbox {string}")
    public void iSelectCheckbox(String checkboxOption) {
        basicActionPage.selectCheckBoxByVisibleText(checkboxOption);
    }

    @Then("Selected checkbox option {string} should be checked")
    public void selectedCheckboxOptionShouldBeChecked(String checkboxOption) {
        basicActionPage.verifySelectCheckBoxByVisibleText(checkboxOption);
    }

    @When("I click on Open Window button")
    public void iClickOnOpenWindowButton() {
        basicActionPage.clickOnOpenWindowButton();
    }

    @Then("New window should be opened with title {string}")
    public void newWindowShouldBeOpenedWithTitle(String title) {
        basicActionPage.verifyIfNewWindowOpened(title);
    }

    @When("I switch back to Parent window")
    public void iSwitchBackToParentWindow() {
        basicActionPage.switchToParentWindow();
    }

    @When("I click on Open Tab")
    public void iClickOnOpenTab() {
        basicActionPage.clickOnOpenTab();
    }


    @Then("Verify if new tab is opened")
    public void verifyIfNewTabIsOpened() {
       basicActionPage.verifyIfLogoIsDisplayed();
    }

    @When("I enter alert name {string}")
    public void iEnterAlertName(String alertName) {
        basicActionPage.inputNameInAlertTextbox(alertName);
    }

    @And("Click on Alert button")
    public void clickOnAlertButton() {
        basicActionPage.clickOnAlertButton();
    }

    @Then("alert pop should be displayed with message {string}")
    public void alertPopShouldBeDisplayedWithMessage(String expectedMessage) {
        basicActionPage.verifyAlertMessage(expectedMessage);
    }
}
