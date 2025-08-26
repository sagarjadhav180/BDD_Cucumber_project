package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;

public class Hooks {

    private final DriverFactory driverFactory;


    public Hooks(DriverFactory driverFactory){
        this.driverFactory = driverFactory;
        System.out.println("=========Browser launched=====================");
    }

//    @Before
//    public void setup(){
//        DriverFactory.getDriver();
//    }

    @After
    public void tearDown(){
        System.out.println("======Closing all browser instances=======");
        driverFactory.quitDriver();
    }

}
