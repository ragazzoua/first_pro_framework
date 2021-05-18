package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private final SelenideElement popUpWindowHeader = $(Selectors.byXpath("//div[@class='jss271']"));
    private final SelenideElement okButton = $(Selectors.byXpath("//button[@class='jss250 jss224 jss226 jss227 jss229 jss230 jss313']"));

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void closePopupIfVisible() {
        if (popUpWindowHeader.is(Condition.visible)) {
            clickOkButton();
        }
    }

    private void clickOkButton() {
        okButton.click();
    }

    public String getText() {
        return "";
    }
}
