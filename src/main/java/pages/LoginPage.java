package pages;

import com.codeborne.selenide.SelenideElement;
import config.EnvConfig;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.PropertyReader;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    private static final String LOCAL_LOGIN = "superadmin";
    private static final String LOCAL_PASSWORD = "erebus";

    public static final SelenideElement loginButton = $(byXpath("//button[@type='submit']"));
    public static final SelenideElement loginField = $(byXpath("//input[@placeholder='Login']"));
    public static final SelenideElement passwordField = $(byXpath("//input[@placeholder='Password']"));

    public LoginPage() {
    }

    public void openReportPortal() throws IOException {
        String reportPortal = PropertyReader.getProperty("report_portal");
        switch (reportPortal) {
            case "local" -> {
                logger.log(Level.INFO, () -> "Open LOCAL Report Portal");
                open(EnvConfig.UI_LOCAL_REPORT_PORTAL_URL);
            }
            case "epam" -> {
                logger.log(Level.INFO, () -> "Open EPAM Report Portal");
                open(EnvConfig.UI_EPAM_REPORT_PORTAL_URL);
            }
            case "demo" -> {
                logger.log(Level.INFO, () -> "Open DEMO Report Portal");
                open(EnvConfig.UI_DEMO_REPORT_PORTAL_URL);
            }
        }
    }

    public void login() throws IOException {
        String reportPortal = PropertyReader.getProperty("report_portal");
        switch (reportPortal) {
            case "local" -> loginLocalReportPortal();
            case "epam" -> loginEPAMReportPortal();
            case "demo" -> loginDemoReportPortal();
        }
    }

    private void loginDemoReportPortal(){
        logger.log(Level.DEBUG, () ->"Login DEMO Report Portal");
        loginButton.click();
    }

    private void loginEPAMReportPortal(){
        logger.log(Level.DEBUG, () ->"Login EPAM Report Portal");
        //NOT IMPLEMENTED YET
    }

    private void loginLocalReportPortal(){
        logger.log(Level.DEBUG, () ->"Login EPAM Report Portal");
        loginField.sendKeys(LOCAL_LOGIN);
        passwordField.sendKeys(LOCAL_PASSWORD);
        loginButton.click();
    }
}
