package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class LaunchesPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(LaunchesPage.class);

    public static final SelenideElement launchesButton = $(byXpath("//span[span[contains(text(),'Launches')]]"));
    private static final List<SelenideElement> launches = $$(byXpath("//a[contains(@href,'#default')]/div/span"));
    private static String ES_FIELD_NAME_XPATH = "//div[contains(@class,'grid-row-wrap')][x]//div[contains(@class,'launch')]/div/a/parent::div/span";
    private static String ES_VALUE_XPATH = "//div[contains(@class,'grid-row-wrap')][x]//div[contains(@class,'launch')]/div/a";
    private static String DS_FIELD_NAME_AND_VALUE_XPATH = "//div[contains(@class,'grid-row-wrap')][Y]//span[contains(text(),'XX')]/parent::div//div[contains(@class,'Chart__total')]";

    public LaunchesPage(){
    }

    public void goToLaunchesPage(){
        logger.log(Level.INFO,() ->"Click Launches button");
        launchesButton.click();
    }

    public void clickOnLaunch(int launch) {
        launches.get(launch).click();
    }

    public int getLaunchESValue(String fieldName, int launch) {
        List<SelenideElement> fieldNames = $$(byXpath(getESFieldNamesXpath(launch)));
        List<SelenideElement> fieldValues = $$(byXpath(getESValuesXpath(launch)));
        fieldValues.get(0).shouldBe(Condition.visible);
        for (int i = 0; i < fieldNames.size(); i++){
            if (fieldNames.get(i).getOwnText().equals(fieldName)){
                logger.info("ES Field name: " + fieldNames.get(i).getOwnText()+ "ES Value: " + fieldValues.get(i).getText());
                return Integer.parseInt(fieldValues.get(i).getText());
            }
        }
        logger.info(() -> "ES Field name: " + fieldName + "ES Value: " + "0");
        return 0;
    }

    public int getLaunchDSValue(String fieldName, int launch){
            SelenideElement resultValue = $(byXpath(getDSValueXpath(fieldName,launch)));
            Selenide.sleep(1000);
            if(!resultValue.exists()) return 0;
            Selenide.sleep(1000);
            return Integer.parseInt(resultValue.getText());
    }

    private static String getESFieldNamesXpath(int launch){
        String fieldNameXpath = ES_FIELD_NAME_XPATH;
        return fieldNameXpath.replace("x", String.valueOf(launch));
    }

    private static String getESValuesXpath(int launch){
        String valueXpath = ES_VALUE_XPATH;
        return valueXpath.replace("x", String.valueOf(launch));
    }

    private static String getDSValueXpath(String fieldName, int launch){
        String valueXpath = DS_FIELD_NAME_AND_VALUE_XPATH;
        return valueXpath.replace("Y", String.valueOf(launch)).replace("XX",fieldName);
    }
}
