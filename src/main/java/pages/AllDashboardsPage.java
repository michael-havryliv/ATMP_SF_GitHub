package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AllDashboardsPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(AllDashboardsPage.class);

    public static final SelenideElement dashboardsButton = $(byXpath("//span[span[contains(text(),'Dashboards')]]"));

    public static final SelenideElement addNewDashboardButton = $(byText("Add New Dashboard"));

    public static final SelenideElement enterDashboardNameInput = $(By.xpath("//input[@placeholder='Enter dashboard name']"));

    public static final SelenideElement addButton = $(By.xpath("//button[text()='Add']"));

    public AllDashboardsPage(WebDriver driver) {
        super(driver);
    }

    public void inputDashboardName(String dashboardName) {
        logger.log(Level.INFO, () -> "Input dashboard name " + dashboardName);
        enterDashboardNameInput.sendKeys(dashboardName);
    }

    public void checkDashboardNameExists(String dashboardName) {
        logger.log(Level.INFO,() ->"Check if dashboard name: '" + dashboardName + "' exists");
        $(byText(dashboardName)).should(Condition.exist);
    }
}
