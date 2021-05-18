package app_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static constants.UiConstants.BASE_URL;

public class Application {
    private WebDriver driver;
    private String browser;
    private MainPage mainPage;

    public Application(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
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
