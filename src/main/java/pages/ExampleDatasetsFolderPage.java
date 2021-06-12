package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import logger.TestLogger;
import model.DataSet;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ExampleDatasetsFolderPage extends BasePage {

    private ElementsCollection dataSets = $$(Selectors.byXpath("//tr[@class='file dataset']"));

    private static final String FILE_NAME_TITLE = ".//span[@title]";
    private static final String STATUS_TITLE = ".//span[@class='status-title']";
    private static final String TYPE_TITLE = ".//td[@class='type']/span";
    private static final String SIZE_TITLE = ".//td[@class='size']/span";
    private static final String UPLOAD_TITLE = ".//td[@class='uploaded']/span";

    public ExampleDatasetsFolderPage(WebDriver driver) {
        super(driver);
    }

    public int getFilesCount() {
        int size = dataSets.size();
        TestLogger.reportInfoStep("%s files on the page", size);
        return size;

    }

    public void openFile(int index) {
        dataSets.shouldHave(CollectionCondition.sizeGreaterThan(0)).get(index).doubleClick();
        TestLogger.reportInfoStep("File by index - %s was opened", index);
    }

    public List<DataSet> getFileNames() {
        List<DataSet> fileDataList = new ArrayList<>();
        for (SelenideElement element: dataSets) {
            SelenideElement title = element.$(Selectors.byXpath(FILE_NAME_TITLE));
            SelenideElement status = element.$(Selectors.byXpath(STATUS_TITLE));
            SelenideElement type = element.$(Selectors.byXpath(TYPE_TITLE));
            SelenideElement size = element.$(Selectors.byXpath(SIZE_TITLE));
            SelenideElement upload = element.$(Selectors.byXpath(UPLOAD_TITLE));
            DataSet dataSet = DataSet.builder()
                    .name(title.getText())
                    .status(status.getText())
                    .type(type.getText())
                    .size(size.getText())
                    .upload(upload.getText())
                    .build();
            fileDataList.add(dataSet);
        }
        return fileDataList;
    }


}
