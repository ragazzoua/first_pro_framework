package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import logger.TestLogger;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private final SelenideElement buyMoreCreditsButton = $(Selectors.byXpath("//a[@id='topbar-user-payment-link']"));
    private final SelenideElement exampleDatasetsFolder = $(Selectors.byXpath("//span[@title='Example_Datasets']"));

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBuyMoreCreditsButtonVisible() {
        if (buyMoreCreditsButton.is(Condition.visible)) {
            return true;
        } else {
            return false;
        }
    }

    public void openExampleDatasetsFolder() {
        exampleDatasetsFolder.shouldBe(Condition.visible).click();
        TestLogger.reportInfoStep("Example Datasets folder was opened");
    }
}
