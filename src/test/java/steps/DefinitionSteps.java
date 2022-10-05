package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DefinitionSteps extends BaseSteps{

    @When("User clicks Add New Dashboard button")
    public void userClicksAddNewDashboardButton(){
        getAllDashboardsPage().addNewDashboardButton.click();
    }

    @And("User inputs dashboard name {string}")
    public void userInputsDashboardName(final String dashboardName) {
        getAllDashboardsPage().inputDashboardName(dashboardName);

    }

    @And("User clicks Add button")
    public void userClicksAddButton() {
        getAllDashboardsPage().addButton.click();
    }

    @Then("User check dashboard name {string} exists")
    public void userCheckDashboardNameExists(final String dashboardName) {
        getAllDashboardsPage().checkDashboardNameExists(dashboardName);
    }
}
