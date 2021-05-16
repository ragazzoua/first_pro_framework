package ui_tests;

import app_manager.Application;
import factories.Userfactory;
import model.User;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static final Application application = new Application(BrowserType.CHROME);
    public static User user = Userfactory.getUser();

    @BeforeClass
    public void setup() {
        application.init();
    }

    @AfterClass
    public void stop(){
        application.stop();
    }

    public static Application getApplication() {
        return application;
    }
}
