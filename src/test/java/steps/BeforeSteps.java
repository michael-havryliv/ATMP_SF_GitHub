package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class BeforeSteps extends BaseSteps {

    private static final Logger logger = LogManager.getLogger(BeforeSteps.class);

    @When("User opens report portal")
    public void openReportPortal() throws IOException {
        getLoginPage().openReportPortal();
    }

    @And("User logs in")
    public void userLogsIn() throws IOException {
        logger.log(Level.INFO, ()-> "Click Login button");
        getLoginPage().login();
    }

    @And("User goes to All Dashboards page")
    public void userGoesToAllDashboardsPage() {
        logger.log(Level.INFO, ()-> "Click dashboards button");
        getAllDashboardsPage().dashboardsButton.click();
    }
}
