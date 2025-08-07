package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;
import utils.wait;

public class GooglePage {


    WebDriver driver;

    By searchBox = By.xpath("//textarea[@title='Search']");

    {
        driver = DriverFactory.getDriver();
    }

    public void openGooglePage(){
        driver.get("https://google.com");
    }

    public void enterTextInSearchBox(String textToEnter){
        driver.findElement(searchBox).sendKeys(textToEnter);
    }

    public void selectOption(String optionToBeSelected){
        String xpath = "//ul//li//div[@aria-label='" + optionToBeSelected + "']";
        wait.waitForElementToLoad(xpath);
        driver.findElement(By.xpath(xpath)).click();

    }
}
