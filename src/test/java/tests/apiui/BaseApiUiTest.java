package tests.apiui;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.AllDashboardsPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class BaseApiUiTest {

    private static final String TOKEN = "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NjgyMDk4MDAsInVzZXJfbmFtZSI6ImRlZmF1bHQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiOGI3NjM0MjAtODc3YS00NGE3LWFkZjgtYjQxYTJmYTJmMGZkIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.mRD8IHOmWBkY5h5Y3ouNXQBqckRvJa4edo8jDyGD_G0";
    private static final SelenideElement allDashboardsTitle = $(byXpath("//span[contains(text(),'All Dashboards')]"));

    //DOES NOT WORK
    @BeforeAll
    public static void setUp(){
        Configuration.proxyEnabled = true;

        int tries = 10;
        int counter = 0;
        do {
            open("https://demo.reportportal.io/ui/#default_personal/dashboard", AuthenticationType.BEARER, new BearerTokenCredentials(TOKEN));
            counter++;
        } while (!allDashboardsTitle.isDisplayed() && counter < tries);
    }

    public AllDashboardsPage getAllDashboardPage(){
        return new AllDashboardsPage();
    }
}
