package webdriver;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    private static Logger logger = LogManager.getLogger(Browser.class);

    private static WebDriver webDriver;

    private Browser(){

    }

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
        logger.info("Loading driver");
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    public static void closeDriver(){
        if(webDriver != null){
            logger.info("Closing driver");
            getWebDriver().quit();
            setWebDriver(null);
            WebDriverRunner.setWebDriver(null);
        }
    }

}
