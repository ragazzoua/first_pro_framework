package properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {
    private static Properties projectProperties;

    public static Properties getProperties() {
        return projectProperties;
    }

    public static void setMainSettings() {
        String target = System.getProperty("target", "local");
        projectProperties = new Properties();
        try {
            projectProperties.load(new FileReader(String.format("src/main/resources/%s.properties", target)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
