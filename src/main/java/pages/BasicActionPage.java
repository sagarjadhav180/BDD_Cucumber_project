package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import utils.CommonUtils;
import utils.DriverFactory;
import utils.WaitUtil;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class BasicActionPage {

    private WebDriver driver;
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
    By mentorShipTile = By.xpath("//a[text()='Mentorship']");
    String mentorShipTitle = ("//h1[text()='Mentorship']");
//    By iframe = By.xpath("//iframe[@id='courses-iframe']");
    private final String frameId = "courses-iframe";

    public BasicActionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPractisePage(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    public void practicePageLabel(){
        WaitUtil.waitForElementToLoad(PracticePageLabel);
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
        WaitUtil.fluentWaitForElementTobeDisplayed(LoginButton);
    }

    public void enterCountryInAutoSuggestionBox(String country){
        WaitUtil.waitForElementToLoad(autoSuggestionTextBox);
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

    public void scrollToTheCourse(String courseName){
        By courseElement = By.xpath("//td[text()='" + courseName + "']");
        CommonUtils.scrollIntoView(courseElement);
    }

    public void viewPrice(String courseName, String price){
        By priceElement = By.xpath("//td[text()='" + courseName + "']//following-sibling::td");
        String actualPrice = driver.findElement(priceElement).getText();
        Assert.assertEquals(actualPrice, price, "actual price is not expected. Actual Price is --> "+actualPrice);
    }

    public void scrollToFootballer(String footballer){
        By footballerElement = (By.xpath("(//table[@id='product'])[2]//tr//td[text()='" + footballer + "']"));
        CommonUtils.scrollIntoView(footballerElement);
    }

    public String getAmount(String footballer){
        return driver.findElement(By.xpath("(//table[@id='product'])[2]//tr//td[text()='"+footballer+"']/parent::tr//td[position()=4]")).getText();
    }

    public void clickOnMentorShipTile(){
        driver.findElement(mentorShipTile).click();
    }

    public Boolean mentorShipTitleVisible(){
        return  WaitUtil.waitForElementToLoad(mentorShipTitle);
    }

    public void scrollToMentorShipTile(){
        CommonUtils.scrollIntoView(mentorShipTile);
    }

    public void switchToIframe(){
        CommonUtils.switchToiFrame(frameId);
    }





}
