package steps;

import config.EnvConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;

public class BeforeSteps extends BaseSteps {

    private static Logger logger = LogManager.getLogger(BeforeSteps.class);

    @When("User opens report portal")
    public void openReportPortal(){
        logger.info("Open Report Portal");
        open(EnvConfig.DEMO_REPORT_PORTAL_URL);
    }

    @And("User logs in")
    public void userLogsIn() {
        logger.info("Click Login button");
        getLoginPage().loginButton.click();
    }

    @And("User goes to All Dashboards page")
    public void userGoesToAllDashboardsPage() {
        logger.info("Click dashboards button");
        getAllDashboardsPage().dashboardsButton.click();
    }
}
