package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private static WebDriver webDriver;

    public BasePage(WebDriver driver){
        webDriver = driver;
    }
}
