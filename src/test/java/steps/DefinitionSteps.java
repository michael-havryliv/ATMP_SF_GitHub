package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefinitionSteps extends BaseSteps{

    private static Logger logger = LogManager.getLogger(DefinitionSteps.class);

    @When("User clicks Add New Dashboard button")
    public void userClicksAddNewDashboardButton(){
        logger.info("Click 'Add new dashboard button'");
        getAllDashboardsPage().addNewDashboardButton.click();
    }

    @And("User inputs dashboard name {string}")
    public void userInputsDashboardName(final String dashboardName) {
        getAllDashboardsPage().inputDashboardName(dashboardName);

    }

    @And("User clicks Add button")
    public void userClicksAddButton() {
        logger.info("Click 'Add' button");
        getAllDashboardsPage().addButton.click();
    }

    @Then("User check dashboard name {string} exists")
    public void userCheckDashboardNameExists(final String dashboardName) {
        getAllDashboardsPage().checkDashboardNameExists(dashboardName);
    }
}
