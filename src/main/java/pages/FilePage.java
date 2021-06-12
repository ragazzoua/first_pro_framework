package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import logger.TestLogger;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class FilePage extends BasePage{
    private final SelenideElement fileNameHeader = $(Selectors.byXpath("//div[@class='dataset-name']"));


    public FilePage(WebDriver driver) {
        super(driver);
    }

    public String getFileName() {
        String name = fileNameHeader.shouldBe(Condition.visible).text();
        TestLogger.reportInfoStep("File name is - %s", name);
        return name;
    }
}
