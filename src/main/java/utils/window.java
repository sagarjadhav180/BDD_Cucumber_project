package utils;

import org.openqa.selenium.WebDriver;

public class window {

    static DriverFactory driverFactory;

//    static{
//        driver = DriverFactory.getDriver();
//    }

    public window(DriverFactory driverFactory){
        driverFactory =  driverFactory;
    }

    //maximize window
    public static void maximizeWindow(){
//        driver.manage().window().maximize();
        driverFactory.driver.manage().window().fullscreen();
    }
}
