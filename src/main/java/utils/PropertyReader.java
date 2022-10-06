package utils;

import java.io.FileInputStream;
import java.io.IOException;

public class PropertyReader {

    public static String getProperty(String property) throws IOException {
        String fileName = "src/main/resources/debug.properties";
        FileInputStream fis = null;
        java.util.Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
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
