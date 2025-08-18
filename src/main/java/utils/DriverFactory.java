package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class DriverFactory {

    public WebDriver driver;

    public DriverFactory(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WaitUtil.init(driver);
        CommonUtils.init(driver);
    }

    public void quitDriver(){
        if(driver != null)
            driver.quit();
    }


}
