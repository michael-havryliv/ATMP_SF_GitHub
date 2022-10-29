package defSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefinitionSteps extends BaseSteps{

    @When("User opens Report Portal")
    public void userOpensReportPortal() throws IOException {
        getLoginPage().openReportPortal();
    }

    @And("User logs in")
    public void userLogsIn() throws IOException {
        getLoginPage().login();
    }

    @And("User goes to ALlDashboards Page")
    public void userGoesToALlDashboardsPage() {
        getAllDashboardsPage().goToAllDashboardsPage();
    }

    @And("User clicks addNewDashboard button")
    public void userClicksAddNewDashboardButton() {
        getAllDashboardsPage().clickAddNewDashboardButton();
    }

    @And("User inputs {string} in dashboard field")
    public void userInputsDashboardsNameInDashboardField(String dashboardName) {
        getAllDashboardsPage().inputDashboardName(dashboardName);
    }

    @And("User clicks add button")
    public void userClicksAddButton() {
        getAllDashboardsPage().clickAddButton();
    }

    @Then("User checks if dashboard {string} exists")
    public void userChecksIfDashboardDashboardsNameExists(String dashboardName) {
        getAllDashboardsPage().checkDashboardNameExists(dashboardName);
    }

    @And("User goes to Launches Page")
    public void userGoesToLaunchesPage() {
        getLaunchesPage().goToLaunchesPage();
    }

    @Then("User checks if {string} has {string} in launch {string}")
    public void userChecksIfESFieldNameHasExpectedESValueInLaunchLaunchNum(String field, String value, String launch) {
        Assertions.assertEquals(Integer.parseInt(value), getLaunchesPage().getLaunchESValue(field,Integer.parseInt(launch)));
    }

    @Then("User checks if all fields have expectedValues in specific launch")
    public void userChecksIfAllFieldsHaveExpectedValuesInSpecificLaunch(DataTable dataTable) {
        Integer launch = Integer.parseInt(dataTable.cell(0,0));
        List<String> tablesValues = dataTable.column(launch-1);
        List<String> expectedStringValues = tablesValues.subList(1, tablesValues.size());
        List<Integer> expectedIntegerValues = new ArrayList<>();
        for (String value : expectedStringValues){
            expectedIntegerValues.add(Integer.parseInt(value));
        }
        Assertions.assertArrayEquals(expectedIntegerValues.toArray(),getLaunchesPage().getLaunchValues(getFieldNames(),launch).toArray());
    }

    private ArrayList<String> getFieldNames() {
        ArrayList<String> fieldNames = new ArrayList<>();
        fieldNames.add("total");
        fieldNames.add("passed");
        fieldNames.add("failed");
        fieldNames.add("skipped");
        fieldNames.add("pb");
        fieldNames.add("ab");
        fieldNames.add("si");
        fieldNames.add("ti");
        return fieldNames;
    }
}
