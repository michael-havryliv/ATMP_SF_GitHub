package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AllDashboardsPage;
import pages.DashboardPage;
import pages.LaunchesPage;
import pages.LoginPage;

import java.io.IOException;

import static pages.LoginPage.openReportPortal;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    @BeforeAll
    public void setUp() throws IOException {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        openReportPortal();
        getLoginPage().login();
    }

    @AfterAll
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
