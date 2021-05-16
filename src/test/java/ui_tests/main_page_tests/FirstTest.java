package ui_tests.main_page_tests;

import org.testng.annotations.Test;
import ui_tests.BaseTest;

public class FirstTest extends BaseTest {


    @Test
    public void openPage(){
        application.getMainPageHelper().login(user.getLogin(), user.getPassword());
    }
}
