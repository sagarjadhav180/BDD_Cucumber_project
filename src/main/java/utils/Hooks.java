package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;

public class Hooks {

    private DriverFactory driverFactory;


    public Hooks(DriverFactory driverFactory){
        this.driverFactory = driverFactory;
    }

//    @Before
//    public void setup(){
//        DriverFactory.getDriver();
//    }

    @After
    public void tearDown(){
        driverFactory.quitDriver();
    }

}
