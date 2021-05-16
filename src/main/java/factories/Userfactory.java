package factories;

import model.User;

import java.util.ResourceBundle;

public class Userfactory {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("user");

    public static User getUser() {
        return new User(resourceBundle.getString("name"), resourceBundle.getString("pass"));
    }
}
