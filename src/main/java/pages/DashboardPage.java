package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private static final Logger logger = LogManager.getLogger(DashboardPage.class);

    private static final String widgetHeaderTemplate = "//div[contains(text(),'{HEADER}')]";
    private static final String widgetWrapperTemplate = "//div[contains(text(),'{HEADER}')]//ancestor::div[contains(@class,'react-grid-item')]";
    private static final String widgetResizableHandleTemplate = "//div[contains(text(),'{HEADER}')]//ancestor::div[contains(@class,'react-grid-item')]/span";
    private static final String widgetSVGElementTemplate = "//div[contains(text(),'{HEADER}')]//ancestor::div[contains(@class,'react-grid-item')]//div[@class='c3']//*[local-name()='svg']";
    private static final String widgetChartWrapperTemplate = "//div[contains(text(),'{HEADER}')]//ancestor::div[contains(@class,'react-grid-item')]//*[local-name()='rect' and @class='c3-event-rect']";

    public DashboardPage() {
    }

    public void scrollWidgetIntoView(String widgetHeader) {
        SelenideElement widgetHeaderXpath = $(byXpath(getXpathWithWidgetHeader(widgetHeaderTemplate, widgetHeader)));
        logger.log(Level.DEBUG,() -> "Scroll into " + widgetHeaderXpath + " wigdet header");
        widgetHeaderXpath.scrollIntoView(true);
    }

    public boolean checkWidgetHeaderIsDisplayed(String header) {
        SelenideElement widgetHeaderXpath = $(byXpath(getXpathWithWidgetHeader(widgetHeaderTemplate, header)));
        logger.log(Level.DEBUG,() -> "Check widget header: " + widgetHeaderXpath + " is displayed");
        return widgetHeaderXpath.isDisplayed();
    }

    public void resizeWidgetWithOffset(String header, int w, int h) {
        SelenideElement widgetResizeHandleXpath = $(byXpath(getXpathWithWidgetHeader(widgetResizableHandleTemplate, header)));
        Selenide.actions()
                .dragAndDropBy(widgetResizeHandleXpath, w, h)
                .build()
                .perform();
        logger.log(Level.DEBUG,() -> "Resized widget with handle xpath: " + widgetResizeHandleXpath);
        logger.log(Level.DEBUG,() -> "Width offset: " + w + " Height offset: " + h);
    }

    public int getWidgetWidth(String header) {
        SelenideElement widgetSVGElement = $(byXpath(getXpathWithWidgetHeader(widgetSVGElementTemplate, header)));
        return Integer.parseInt(Objects.requireNonNull(widgetSVGElement.getAttribute("width")));
    }

    public int getWidgetHeight(String header) {
        SelenideElement widgetSVGElement = $(byXpath(getXpathWithWidgetHeader(widgetSVGElementTemplate, header)));
        return Integer.parseInt(Objects.requireNonNull(widgetSVGElement.getAttribute("height")));
    }

    public String getWidgetPosition(String header) {
        SelenideElement widgetPosition = $(byXpath(getXpathWithWidgetHeader(widgetWrapperTemplate, header)));
        String widgetStyle = widgetPosition.getAttribute("style");
        return widgetStyle.substring(widgetStyle.indexOf("translate")+10, widgetStyle.length()-2);
    }

    public int getWidgetChartWidth(String header) {
        SelenideElement widgetChartWrapper = $(byXpath(getXpathWithWidgetHeader(widgetChartWrapperTemplate, header)));
        int result = Integer.parseInt(Objects.requireNonNull(widgetChartWrapper.getAttribute("width")));
        logger.log(Level.DEBUG,() -> "Widget chart width: " + result);
        return result;
    }

    public int getWidgetChartHeight(String header) {
        SelenideElement widgetChartWrapper = $(byXpath(getXpathWithWidgetHeader(widgetChartWrapperTemplate, header)));
        int result = Integer.parseInt(Objects.requireNonNull(widgetChartWrapper.getAttribute("height")));
        logger.log(Level.DEBUG,() -> "Widget chart height: " + result);
        return result;
    }

    private String getXpathWithWidgetHeader(String template, String widgetHeader){
        return template.replace("{HEADER}", widgetHeader);
    }
}
