package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final SelenideElement popUpWindowHeader = $(Selectors.byXpath("//div[@class='jss271']"));
    private final SelenideElement okButtonOnPopUpWindow = $(Selectors.byXpath("//button[@class='jss250 jss224 jss226 jss227 jss229 jss230 jss313']"));
    private final SelenideElement emailAddressField = $(Selectors.byXpath("//input[@id='email']"));
    private final SelenideElement passwordField = $(Selectors.byXpath("//input[@id='password']"));
    private final SelenideElement signInButton = $(Selectors.byXpath("//button[@id='signInButton']"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void closePopupIfVisible() {
        if (popUpWindowHeader.is(visible)) {
            clickOkButtonOnPopUp();
        }
    }

    private void clickOkButtonOnPopUp() {
        okButtonOnPopUpWindow.click();
    }

    public MainPage login(String userName, String password) {
        closePopupIfVisible();
        fillInEmailField(userName);
        fillInPasswordField(password);
        clickSignInButton();
        return new MainPage(driver);
    }

    private void fillInPasswordField(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.val(password);
    }

    private void fillInEmailField(String userName) {
        emailAddressField.shouldBe(visible).click();
        emailAddressField.val(userName);
    }

    private void clickSignInButton() {
        signInButton.shouldBe(visible).click();
    }

    public String getText() {
        return "";
    }
}
