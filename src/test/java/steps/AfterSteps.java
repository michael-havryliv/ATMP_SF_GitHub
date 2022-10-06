package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import webdriver.Browser;

public class AfterSteps extends BaseSteps{

    @After
    public void tearDown(){
        Browser.closeDriver();
    }

    @AfterStep
    public void makeScreenshot(){
        Selenide.screenshot(System.currentTimeMillis() + "step");
    }

}
