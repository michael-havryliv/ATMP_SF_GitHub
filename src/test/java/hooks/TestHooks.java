package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestHooks {

    private static final Logger logger = LogManager.getLogger(TestHooks.class);

    @Before("@RegularTest")
    public void setUp(Scenario scenario){
        logger.info(() -> "Before: " + scenario);
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @After("@RegularTest")
    public void tearDown(Scenario scenario){
        logger.info(() -> "After: " + scenario);
        Selenide.closeWebDriver();
    }
}
