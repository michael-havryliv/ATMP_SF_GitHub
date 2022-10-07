package utils;

import java.io.FileInputStream;
import java.io.IOException;

public class PropertyReader {

    private static String DEBUG_PROP_PATH = "src/main/resources/debug.properties";

    public static String getProperty(String property) throws IOException {

        FileInputStream fis = null;
        java.util.Properties prop = null;

        try {
            fis = new FileInputStream(DEBUG_PROP_PATH);
            prop = new java.util.Properties();
            prop.load(fis);
        } catch(IOException fnfe) {
            fnfe.printStackTrace();
        } finally {
            if (fis != null) fis.close();
        }
        return prop.getProperty(property);

    }
}
