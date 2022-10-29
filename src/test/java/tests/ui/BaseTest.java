package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.AllDashboardsPage;
import pages.DashboardPage;
import pages.LaunchesPage;
import pages.LoginPage;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    @BeforeEach
    public void setUp() throws IOException {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        getLoginPage().openReportPortal();
        getLoginPage().login();
    }

    @AfterEach
    public void quit(){
        Selenide.closeWebDriver();
    }

    public LoginPage getLoginPage(){
        return new LoginPage();
    }

    public AllDashboardsPage getAllDashboardsPage(){
        return new AllDashboardsPage();
    }

    public DashboardPage getDashboardPage(){
        return new DashboardPage();
    }

    public LaunchesPage getLaunchesPage(){
        return new LaunchesPage();
    }

}
