package tests.apiui;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class SampleApiUiTest extends BaseApiUiTest{

    private static final String DASHBOARD_NAME = "michael";
    //DOES NOT WORK
    @Test
    public void sampleTest(){
        getAllDashboardPage().clickAddNewDashboardButton();
        getAllDashboardPage().inputDashboardName(DASHBOARD_NAME);
        getAllDashboardPage().clickAddButton();
        getAllDashboardPage().checkDashboardNameExists(DASHBOARD_NAME);
    }
}
