package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterTest;

public class Hooks {

    @Before
    public void setup(){
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }

}
