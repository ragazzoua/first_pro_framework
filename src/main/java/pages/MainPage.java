package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(By.name("login"), username);
        type(By.name("pass"), password);
        click(By.xpath("//input[@type='submit' and @value='Войти']"));
    }

    public String getText() {
        return "";
    }
}
