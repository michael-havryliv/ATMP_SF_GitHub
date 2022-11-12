package config;

import lombok.SneakyThrows;
import utils.PropertyReader;

public class EnvConfig {

    private EnvConfig(){}

    public static final String UI_DEMO_REPORT_PORTAL_URL = "https://demo.reportportal.io/ui/#login";
    public static final String UI_EPAM_REPORT_PORTAL_URL = "https://rp.epam.com/ui/#login";
    public static final String UI_LOCAL_REPORT_PORTAL_URL = "http://localhost:8080/ui/#login";
    public static final String API_DEMO_RP_BASE_URL = "https://demo.reportportal.io/api";
    public static final String API_LOCAL_RP_BASE_URL = "http://localhost:8080/api";

    @SneakyThrows
    public static String getBaseAPIURL(){
        String baseURI = "";
        switch (PropertyReader.getProperty("report_portal")) {
            case "local"-> baseURI = API_LOCAL_RP_BASE_URL;
            case "epam" -> baseURI = "Not implemented yet";
            case "demo" -> baseURI = API_DEMO_RP_BASE_URL;
        }
        return baseURI;
    }
}
