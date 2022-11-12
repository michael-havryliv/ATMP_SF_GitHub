package bdd.defSteps;

import pages.AllDashboardsPage;
import pages.DashboardPage;
import pages.LaunchesPage;
import pages.LoginPage;

public abstract class BaseSteps {

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
