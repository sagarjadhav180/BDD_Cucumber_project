package utils;

import com.beust.ah.A;
import io.cucumber.java.et.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

public class CommonUtils {


    private static JavascriptExecutor javascriptExecutor ;
    private static WebDriver driver;


    public static void init(WebDriver driverInstance) {
        if (driver == null) {
            driver = driverInstance;
        }
        javascriptExecutor = (JavascriptExecutor)driver;
    }
    

    public static void scrollIntoView(By xPath){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(xPath));
    }

    public static void jsClick(WebElement button){
        javascriptExecutor.executeScript("arguments[0].click()",button);
    }

    public static void mouseHoverAndClick(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
    }

    public static void selectOptionFromDropDown(WebElement dropdown, String optionToBeSelected){
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionToBeSelected);
    }

    public static Boolean verifyIfOptionSelectedFromDropdown(WebElement webElement, String option){
        Boolean flag = null;
        Select select = new Select(webElement);
        String optionSelected = select.getFirstSelectedOption().getText();
        System.out.println("=========="+optionSelected+"===========");
        if(optionSelected.equals(option)){
            return flag = true;
        }
        else
            return flag = false;
    }


}
