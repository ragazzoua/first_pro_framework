package ui_tests.main_page_tests;

import org.testng.annotations.Test;
import properties.ProjectProperties;
import ui_tests.BaseTest;

public class FirstTest extends BaseTest {


    @Test
    public void openPage(){
        application.getLoginPage().login(ProjectProperties.getProperties().getProperty("name"), ProjectProperties.getProperties().getProperty("password"));
    }
}
