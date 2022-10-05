package steps;

import config.EnvConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;

public class BeforeSteps extends BaseSteps {

    private static Logger logger = LogManager.getLogger(BeforeSteps.class);

    @Given("User opens report portal")
    public void openReportPortal(){
        open(EnvConfig.DEMO_REPORT_PORTAL_URL);
    }

    @And("User logs in")
    public void userLogsIn() {
        getLoginPage().loginButton.click();
    }

    @And("User goes to All Dashboards page")
    public void userGoesToAllDashboardsPage() {
        getAllDashboardsPage().dashboardsButton.click();
    }
}
