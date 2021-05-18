package app_manager;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import properties.ProjectProperties;

import java.util.concurrent.TimeUnit;

import static properties.ProjectProperties.setMainSettings;

public class Application {
    private WebDriver driver;
    private String browser;
    private MainPage mainPage;

    public Application(String browser) {
        this.browser = browser;
    }

    public void init() {
        setMainSettings();
        Selenide.open(ProjectProperties.getProperties().getProperty("baseUrl"));
        driver = WebDriverRunner.driver().getWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }


    public void stop() {
        driver.quit();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public MainPage getMainPage() {
        return mainPage;
    }
}
