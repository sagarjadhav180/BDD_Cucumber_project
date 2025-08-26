package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.testng.annotations.AfterSuite;

public class Listener implements ConcurrentEventListener {

    private static final Logger LOG = LogManager.getLogger(Listener.class);


    @Before
    public void beforeApiTests() {
//        LOG.info("========== [API] Starting API scenario ==========");
//        ExtentCucumberAdapter.addTestStepLog("========== [API] Starting API scenario ==========");
    }

    @After
    public void afterScenario(Scenario scenario) {
//        String tags = scenario.getSourceTagNames().toString();
//        LOG.info("[{}] Scenario finished: {}");
//        ExtentCucumberAdapter.addTestStepLog("================ [{}] Scenario finished: {} ================");
//        LOG.info(tags);
//        LOG.info(scenario.getName());
    }


    /**
     * Set the event publisher. The plugin can register event listeners with the
     * publisher.
     *
     * @param publisher the event publisher
     */
    @Override
    public void setEventPublisher(EventPublisher publisher) {

    }


}
