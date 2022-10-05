package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    public SelenideElement loginButton = $(byText("Login"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
