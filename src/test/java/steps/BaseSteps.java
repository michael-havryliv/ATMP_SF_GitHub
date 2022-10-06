package steps;

import pages.AllDashboardsPage;
import pages.LoginPage;
import webdriver.Browser;

public class BaseSteps {

    public LoginPage getLoginPage(){
        return new LoginPage(Browser.getWebDriver());
    }

    public AllDashboardsPage getAllDashboardsPage(){
        return new AllDashboardsPage(Browser.getWebDriver());
    }

}
