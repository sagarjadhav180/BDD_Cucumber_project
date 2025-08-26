package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.EmailUtil;
import utils.PropertyReader;
import utils.RetryAnalyzer;


@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepDefinitions", "utils"},
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "utils.Listener"
        },
        monochrome = false,
        tags = "@json_file"
)

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestRunner extends AbstractTestNGCucumberTests {

        private static final String reportPath = "target/report/ExtentPdf.pdf";

        @AfterSuite
        private void sendEmail(){
                if(PropertyReader.getProperty("mail.trigger").equals("true"))
                        EmailUtil.sendReportEmail("sagar.jadhav180@gmail.com", reportPath);
                else {
                        System.out.println("📭 Email sending is disabled");
                }
        }

        @DataProvider(parallel = true)
        public Object[][] scenarios(){
                return  super.scenarios();
        }

}
