package pages;

import com.codeborne.selenide.SelenideElement;
import config.EnvConfig;
import io.cucumber.java.eo.Se;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage{

    private static Logger logger = LogManager.getLogger(LoginPage.class);

    private static final String LOCAL_LOGIN = "superadmin";
    private static final String LOCAL_PASSWORD = "erebus";

    public SelenideElement loginButton = $(byXpath("//button[@type='submit']"));
    public SelenideElement loginField = $(byXpath("//input[@placeholder='Login']"));
    public SelenideElement passwordField = $(byXpath("//input[@placeholder='Password']"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openReportPortal() throws IOException {
        String reportPortal = PropertyReader.getProperty("report_portal");
        switch (reportPortal){
            case "local":
                open(EnvConfig.LOCAL_REPORT_PORTAL_URL);
                break;
            case "demo":
                logger.info("Open DEMO Report Portal");
                open(EnvConfig.DEMO_REPORT_PORTAL_URL);
                break;
            case "epam":
                logger.info("Open EPAM Report Portal");
                open(EnvConfig.EPAM_REPORT_PORTAL_URL);
                break;
        }
    }

    public void login() throws IOException {
        String reportPortal = PropertyReader.getProperty("report_portal");
        switch (reportPortal){
            case "local":
                loginLocalReportPortal();
                break;
            case "demo":
                loginDemoReportPortal();
                break;
            case "epam":
                loginEPAMReportPortal();
                break;
        }
    }

    private void loginDemoReportPortal(){
        logger.info("Login DEMO Report Portal");
        loginButton.click();
    }

    private void loginEPAMReportPortal(){
        logger.info("Login EPAM Report Portal");
        //NOT IMPLEMENTED YET
    }

    private void loginLocalReportPortal(){
        logger.info("Login EPAM Report Portal");
        loginField.sendKeys(LOCAL_LOGIN);
        passwordField.sendKeys(LOCAL_PASSWORD);
        loginButton.click();
    }
}
