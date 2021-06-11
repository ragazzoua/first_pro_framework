package ui_tests.main_page_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import properties.ProjectProperties;
import ui_tests.BaseTest;

public class FirstTest extends BaseTest {
    private String userName = ProjectProperties.getProperties().getProperty("name");
    private String userPassword = ProjectProperties.getProperties().getProperty("password");

    @Test
    public void loginWithValidCredentialTest(){
        application.getLoginPage()
                .login(userName, userPassword);

        Assert.assertTrue(application.getMainPage().isBuyMoreCreditsButtonVisible());

        application.getMainPage()
                .openExampleDatasetsFolder();

        Assert.assertEquals(application.getExampleDatasetsFolderPage().getFilesCount(), 57);

        String fileName = application.getExampleDatasetsFolderPage().getFileNames().get(1).getName();
        application.getExampleDatasetsFolderPage().openFile(1);

        Assert.assertEquals(fileName, application.getFilePage().getFileName());
    }
}
