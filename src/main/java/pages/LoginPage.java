package pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    private static Logger logger = LogManager.getLogger(LoginPage.class);

    public SelenideElement loginButton = $(byXpath("//button[@type='submit']"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
