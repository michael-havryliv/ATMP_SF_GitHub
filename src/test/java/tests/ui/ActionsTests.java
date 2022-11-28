package tests.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActionsTests extends BaseUITest {

    private static final String DASHBOARD_NAME = "DEMO DASHBOARD";
    private static final String WIDGET_HEADER = "PASSING RATE";
    private static final String LAUNCH_STAT_AREA_WIDGET = "LAUNCH STATISTICS AREA";
    private static final String LAUNCH_STAT_BAR_WIDGET = "LAUNCH STATISTICS BAR";

    private static final int WIDGET_WIDTH_OFFSET = 113;
    private static final int WIDGET_HEIGHT_OFFSET = 71;

    @BeforeEach
    public void goToDemoDashboard(){
        getAllDashboardsPage().goToAllDashboardsPage();
        getAllDashboardsPage().goToDashboard(DASHBOARD_NAME);
    }

    @Test
    void scrollToAnElementTest(){
        getDashboardPage().scrollWidgetIntoView(WIDGET_HEADER);
        Assertions.assertTrue(getDashboardPage().checkWidgetHeaderIsDisplayed(WIDGET_HEADER));
    }

    @Test
    void resizeWidgetTest(){
        int newWidgetWidth = getDashboardPage().getWidgetWidth(LAUNCH_STAT_AREA_WIDGET) - WIDGET_WIDTH_OFFSET;
        int newWidgetHeight = getDashboardPage().getWidgetHeight(LAUNCH_STAT_AREA_WIDGET) - WIDGET_HEIGHT_OFFSET;

        getDashboardPage().resizeWidgetWithOffset(LAUNCH_STAT_AREA_WIDGET, -WIDGET_WIDTH_OFFSET, -WIDGET_HEIGHT_OFFSET);

        Assertions.assertEquals(newWidgetWidth, getDashboardPage().getWidgetWidth(LAUNCH_STAT_AREA_WIDGET));
        Assertions.assertEquals(newWidgetHeight, getDashboardPage().getWidgetHeight(LAUNCH_STAT_AREA_WIDGET));

        //back to default size
        getDashboardPage().resizeWidgetWithOffset(LAUNCH_STAT_AREA_WIDGET, WIDGET_WIDTH_OFFSET, WIDGET_HEIGHT_OFFSET);
    }

    @Test
    void checkOtherWidgetMovesWhileResizingTest(){
        String defaultSecondWidgetPosition = getDashboardPage().getWidgetPosition(LAUNCH_STAT_BAR_WIDGET);

        getDashboardPage().resizeWidgetWithOffset(LAUNCH_STAT_AREA_WIDGET, WIDGET_WIDTH_OFFSET, WIDGET_HEIGHT_OFFSET);

        Assertions.assertNotEquals(defaultSecondWidgetPosition, getDashboardPage().getWidgetPosition(LAUNCH_STAT_BAR_WIDGET));

        //back to default size
        getDashboardPage().resizeWidgetWithOffset(LAUNCH_STAT_AREA_WIDGET, -WIDGET_WIDTH_OFFSET, -WIDGET_HEIGHT_OFFSET);
    }

    @Test
    void checkWidgetChartResizesTest(){
        int chartWidth = getDashboardPage().getWidgetChartWidth(LAUNCH_STAT_AREA_WIDGET);
        int chartHeight = getDashboardPage().getWidgetChartHeight(LAUNCH_STAT_AREA_WIDGET);

        getDashboardPage().resizeWidgetWithOffset(LAUNCH_STAT_AREA_WIDGET, -WIDGET_WIDTH_OFFSET, -WIDGET_HEIGHT_OFFSET);

        Assertions.assertNotEquals(chartWidth, getDashboardPage().getWidgetChartWidth(LAUNCH_STAT_AREA_WIDGET));
        Assertions.assertNotEquals(chartHeight, getDashboardPage().getWidgetChartHeight(LAUNCH_STAT_AREA_WIDGET));

        //back to default size
        getDashboardPage().resizeWidgetWithOffset(LAUNCH_STAT_AREA_WIDGET, WIDGET_WIDTH_OFFSET, WIDGET_HEIGHT_OFFSET);
    }
}
