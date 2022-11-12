package tests.api;

import config.EndPointsConfig;
import models.dashboard.Dashboard;
import models.dashboard.DashboardWithWidged;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DashboardTest extends BaseAPITest{

    @Test
    public void createDashboardTest(){
        Dashboard dashboard = new Dashboard(
                "My description",
                "myNewDashboard",
                true);
        var response = given()
                .spec(requestSpecification)
                .body(dashboard)
                .when().post(EndPointsConfig.getDashboardEP())
                .then().assertThat().statusCode(201);
        response.log().all();
    }

    @Test
    public void modifyDashboardTest(){
        DashboardWithWidged dashboardWithWidged = new DashboardWithWidged();
        dashboardWithWidged.setName("changedName");
        given()
                .spec(requestSpecification)
                .body(dashboardWithWidged)
                .when().put(EndPointsConfig.getDashboardIdEP(30))
                .then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void deleteDashboardTest(){
        var response = given()
                .spec(requestSpecification)
                .when().delete(EndPointsConfig.getDashboardIdEP(3))
                .then().assertThat().statusCode(200);
        response.log().all();
    }

}
