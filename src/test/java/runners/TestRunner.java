package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import utils.EmailUtil;

import java.util.Arrays;


@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepDefinitions", "utils"},
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "utils.Listener"
        },
        monochrome = true,
        tags = "@iframeHandling"
)

public class TestRunner extends AbstractTestNGCucumberTests {

        private static final String reportPath = "target/report/ExtentPdf.pdf";

        @AfterSuite
        private void sendEmail(){
                EmailUtil.sendReportEmail("sagar.jadhav180@gmail.com", reportPath);

        }

        @DataProvider(parallel = true)
        public Object[][] scenarios(){
                return  super.scenarios();
        }

}
