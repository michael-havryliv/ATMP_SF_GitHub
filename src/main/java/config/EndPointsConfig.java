package config;

import lombok.SneakyThrows;
import utils.PropertyReader;

public class EndPointsConfig {

    private EndPointsConfig(){}

    private static final String DASHBOARD = "/v1/{projectName}/dashboard";
    private static final String DASHBOARD_ID = "/v1/{projectName}/dashboard/{dashboardId}";
    private static final String WIDGET = "/v1/{projectName}/widget";
    private static final String WIDGET_ID = "/v1/{projectName}/widget/{widgetId}";

    @SneakyThrows
    public static String getDashboardEP(){
        return getEndPointWithProjectName(DASHBOARD);
    }

    @SneakyThrows
    public static String getDashboardIdEP(int dashboardId){
        String endPoint = getEndPointWithProjectName(DASHBOARD_ID);
        return endPoint.replace("{dashboardId}", String.valueOf(dashboardId));
    }

    public static String getWidgetEP(){
        return getEndPointWithProjectName(WIDGET);
    }

    @SneakyThrows
    public static String getWidgetIdEP(int widgetId){
        String endPoint = getEndPointWithProjectName(WIDGET_ID);
        return endPoint.replace("{widgetId}", String.valueOf(widgetId));
    }

    @SneakyThrows
    private static String getEndPointWithProjectName(String templateEP){
        String endPoint = "";
        switch (PropertyReader.getProperty("report_portal")){
            case "demo" :
                endPoint = templateEP.replace("{projectName}", "DEFAULT_PERSONAL");
                break;
            case "local":
                endPoint = templateEP.replace("{projectName}","SUPERADMIN_PERSONAL");
                break;
        }
        return endPoint;
    }
}