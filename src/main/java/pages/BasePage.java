package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private static WebDriver webDriver;

    public BasePage(WebDriver driver){
        webDriver = driver;
    }
}
