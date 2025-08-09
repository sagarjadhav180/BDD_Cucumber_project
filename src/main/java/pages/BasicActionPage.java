package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import utils.CommonUtils;
import utils.DriverFactory;
import utils.wait;

import java.io.File;
import java.io.IOException;

public class BasicActionPage {

    static WebDriver driver;
    By PracticePageLabel = By.xpath("//h1[text()='Practice Page']");
    By MouseHoverButton = By.xpath("//button[text()='Mouse Hover']");
    By LoginButton = By.xpath("//button[text()='Login']");

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

}
