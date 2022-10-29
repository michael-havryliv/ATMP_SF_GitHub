package tests.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DashboardsTests extends BaseTest{

    private static final String DASHBOARD_NAME = "report_portal_dashboard";

    @BeforeEach
    public void goToAllDashboardsPage(){
        getAllDashboardsPage().goToAllDashboardsPage();
    }

    @Disabled
    @Test
    public void addNewDashboardTest(){
        getAllDashboardsPage().clickAddNewDashboardButton();
        getAllDashboardsPage().inputDashboardName(DASHBOARD_NAME);
        getAllDashboardsPage().clickAddButton();
        getAllDashboardsPage().goToAllDashboardsPage();
        getAllDashboardsPage().checkDashboardNameExists(DASHBOARD_NAME);
    }

}
