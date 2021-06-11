package app_manager;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import pages.ExampleDatasetsFolderPage;
import pages.LoginPage;
import pages.MainPage;
import pages.FilePage;
import properties.ProjectProperties;

import java.util.concurrent.TimeUnit;

import static properties.ProjectProperties.setMainSettings;

public class Application {
    private WebDriver driver;
    private String browser;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ExampleDatasetsFolderPage exampleDatasetsFolderPage;
    private FilePage filePage;

    public Application(String browser) {
        this.browser = browser;
    }

    public void init() {
        setMainSettings();
        Selenide.open(ProjectProperties.getProperties().getProperty("baseUrl"));
        driver = WebDriverRunner.driver().getWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        exampleDatasetsFolderPage = new ExampleDatasetsFolderPage(driver);
        filePage = new FilePage(driver);
    }


    public void stop() {
        Selenide.closeWebDriver();
    }

    public void acceptAlert() {
        Selenide.switchTo().alert().accept();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
    public MainPage getMainPage() {
        return mainPage;
    }

    public ExampleDatasetsFolderPage getExampleDatasetsFolderPage() {
        return exampleDatasetsFolderPage;
    }

    public FilePage getFilePage() {
        return filePage;
    }
}
