package utils;

import dev.failsafe.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class wait {

    static WebDriver driver;

    static {
        driver = DriverFactory.getDriver();
    }

    //explicit wait
    public static void waitForElementToLoad(String xpath){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofMillis(3000) );
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    public static void waitForElementToLoad(By xpath){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofMillis(3000) );
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath));
    }

}
