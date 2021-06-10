package ui_tests.main_page_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import properties.ProjectProperties;
import ui_tests.BaseTest;

public class FirstTest extends BaseTest {

    @Test
    public void loginWithValidCredentialTest(){
        MainPage mainPage = application.getLoginPage()
                .login(ProjectProperties.getProperties().getProperty("name"), ProjectProperties.getProperties().getProperty("password"));
        Assert.assertTrue(mainPage.isBuyMoreCreditsButtonVisible());
    }
}
