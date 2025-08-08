package utils;

import io.cucumber.java.et.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.xpath.XPath;

public class CommonUtils {


    static JavascriptExecutor javascriptExecutor ;
    static WebDriver driver;

    static {
        driver = DriverFactory.getDriver();
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public static void scrollIntoView(By xPath){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(xPath));
    }

    public static void jsClick(WebElement button){
        javascriptExecutor.executeScript("arguments[0].click()",button);
    }
}
