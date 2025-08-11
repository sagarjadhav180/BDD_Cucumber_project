package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import utils.CommonUtils;
import utils.DriverFactory;
import utils.wait;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class BasicActionPage {

    static WebDriver driver;
    By PracticePageLabel = By.xpath("//h1[text()='Practice Page']");
    By MouseHoverButton = By.xpath("//button[text()='Mouse Hover']");
    By LoginButton = By.xpath("//button[text()='Login']");
    By autoSuggestionTextBox = By.xpath("//input[@id='autocomplete']");
    By dropDown = By.xpath("//select[@id='dropdown-class-example']");
    By openWindowButton = By.xpath("//button[text()='Open Window']");
    By openTab = By.xpath("//a[text()='Open Tab']");
    By logoImage = By.xpath("(//img[@alt='Logo'])[1]");
    By alertTextBox = By.xpath("//input[@placeholder='Enter Your Name']");
    By alertButton = By.xpath("//input[@value='Alert']");

    static {
        driver = DriverFactory.getDriver();
    }

    public void openPractisePage(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    public void practicePageLabel(){
        wait.waitForElementToLoad(PracticePageLabel);
    }

    public void clickOnRadioButton(String button){
        String xpath = String.format("//input[@type='radio' and @name='radioButton' and @value='%s']", button);
        WebElement buttonToClick = driver.findElement(By.xpath(xpath));
        buttonToClick.click();
    }

    public void clickOnButton(String button){
        String xpath = String.format("//button[text()='"+button+"']");
        WebElement buttonToClick = driver.findElement(By.xpath(xpath));
        buttonToClick.click();
    }

    public void checkIfRadioButtonClicked(String button){
        String xpath = String.format("//input[@type='radio' and @name='radioButton' and @value='%s']", button);
        WebElement buttonClicked = driver.findElement(By.xpath(xpath));
        Assert.assertTrue(buttonClicked.isSelected());
    }

    public void scrollToMouseHoverButton(){
        CommonUtils.scrollIntoView(MouseHoverButton);
    }

    public void mouseHoverButton(){
        Assert.assertTrue(driver.findElement(MouseHoverButton).isDisplayed());
    }

    public void jsClickOnButton(String button)  {
        CommonUtils.jsClick(driver.findElement(By.xpath("//button[text()='"+button+"']")));
    }

    public void loginButtonDisplayed(){
        wait.fluentWaitForElementTobeDisplayed(LoginButton);
    }

    public void enterCountryInAutoSuggestionBox(String country){
        wait.waitForElementToLoad(autoSuggestionTextBox);
        driver.findElement(autoSuggestionTextBox).sendKeys(country);
    }

    public void isEnteredCountryPresentInTheList(String country){
        String countryXpath = "//ul[contains(@class,'autocomplete')]//li[@class='ui-menu-item']//div[text()='"+country+"']";
        Assert.assertTrue(driver.findElement(By.xpath(countryXpath)).isDisplayed());
    }

    public void selectCountrydisplayedInTheList(String country){
        String countryXpath = "//ul[contains(@class,'autocomplete')]//li[@class='ui-menu-item']//div[text()='"+country+"']";
        CommonUtils.mouseHoverAndClick(driver.findElement(By.xpath(countryXpath)));
    }

    public void verifyIfSelectedCountryIsDisplayed(String country){
        String countryXpath = "//ul[contains(@class,'autocomplete')]//li[@class='ui-menu-item']//div[text()='"+country+"']";
    }

    public void selectOptionFromDropDown(String option){
        CommonUtils.selectOptionFromDropDown(driver.findElement(dropDown), option);
    }

    public void verifyIfOptionSelected(String option){
        Boolean flag = CommonUtils.verifyIfOptionSelectedFromDropdown(driver.findElement(dropDown), option);
        Assert.assertTrue(flag);
    }

    public void selectCheckBoxByVisibleText(String checkBoxVisibleText){
        String xpath  = "//div[@id='checkbox-example']//input[@value='"+checkBoxVisibleText.toLowerCase()+"']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void selectCheckBoxByValue(String checkBoxValue){
        String xpath  = "//div[@id='checkbox-example']//input[@value='"+checkBoxValue+"']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void verifySelectCheckBoxByVisibleText(String checkBox){
        String xpath  = "//div[@id='checkbox-example']//input[@value='"+checkBox.toLowerCase()+"']";
        Assert.assertTrue(driver.findElement(By.xpath(xpath)).isSelected());
    }

    public void clickOnOpenWindowButton(){
        driver.findElement(openWindowButton).click();
    }

    public void verifyIfNewWindowOpened(String windowTitle){
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();

        Iterator<String> itr = windows.iterator();
        while(itr.hasNext()){
            String childWindowId = itr.next();
            if(!childWindowId.equals(parentWindow))
                driver.switchTo().window(childWindowId);
        }

        Assert.assertTrue(driver.getTitle().contains(windowTitle));
    }

    public void switchToParentWindow(){
        String parentWindow = driver.getWindowHandle();
        driver.switchTo().window(parentWindow);
    }

    public void clickOnOpenTab(){
        driver.findElement(openTab).click();
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();

        Iterator<String> itr = windows.iterator();
        while(itr.hasNext()){
            String childWindowId = itr.next();
            if(!childWindowId.equals(parentWindow))
                driver.switchTo().window(childWindowId);
        }
    }

    public void verifyIfLogoIsDisplayed(){
        Assert.assertTrue(driver.findElement(logoImage).isDisplayed());
    }

    public void inputNameInAlertTextbox(String alertName){
        driver.findElement(alertTextBox).sendKeys(alertName);
    }

    public void clickOnAlertButton(){
        driver.findElement(alertButton).click();
    }

    public void verifyAlertMessage(String expectedAlertMessage){
        String actualAlertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Expected alert message not displayed. Alert message displayed is --> "+actualAlertMessage);
        driver.switchTo().alert().accept();
    }







}
