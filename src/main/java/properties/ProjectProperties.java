package properties;

import java.util.ResourceBundle;

public class ProjectProperties {
    private static ResourceBundle webProperties = ResourceBundle.getBundle("web");

    public static String getWebProperties() {
        return webProperties.getString("url");
    }
}
