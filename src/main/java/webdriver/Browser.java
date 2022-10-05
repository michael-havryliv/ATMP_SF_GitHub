package webdriver;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver(){
//        if(webDriver == null){
//            loadDriver();
//        }
        return webDriver;
    }

    private static void setWebDriver(WebDriver driver){
        webDriver = driver;
    }

    public static void loadDriver(){
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        setWebDriver(driver);
        WebDriverRunner.setWebDriver(driver);
    }

    public static void closeDriver(){
        if(webDriver != null){
            getWebDriver().quit();
            setWebDriver(null);
            WebDriverRunner.setWebDriver(null);
        }
    }

}
