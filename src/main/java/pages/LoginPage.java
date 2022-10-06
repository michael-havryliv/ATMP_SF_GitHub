package pages;

import com.codeborne.selenide.SelenideElement;
import config.EnvConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage{

    private static Logger logger = LogManager.getLogger(LoginPage.class);

    public SelenideElement loginButton = $(byXpath("//button[@type='submit']"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openReportPortal() throws IOException {
        String reportPortal = PropertyReader.getProperty("report_portal");
        switch (reportPortal){
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
}
