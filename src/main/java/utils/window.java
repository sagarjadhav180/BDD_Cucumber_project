package utils;

import org.openqa.selenium.WebDriver;

public class window {

    static WebDriver driver;

    static{
        driver = DriverFactory.getDriver();
    }

    //maximize window
    public static void maximizeWindow(){
//        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
    }
}
