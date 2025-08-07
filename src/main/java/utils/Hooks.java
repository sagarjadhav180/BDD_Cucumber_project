package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(){
        DriverFactory.tearDown();
    }

}
