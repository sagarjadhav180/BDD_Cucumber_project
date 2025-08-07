package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;
import utils.wait;

public class BasicActionPage {

    static WebDriver driver;
    By PracticePageLabel = By.xpath("//h1[text()='Practice Page']");

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

}
