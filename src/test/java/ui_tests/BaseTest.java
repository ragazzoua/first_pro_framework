package ui_tests;

import app_manager.Application;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static final Application application = new Application(System.getProperty("browser", BrowserType.CHROME));

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
