package testcase;

import Hooks.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC001_LoginPage extends BaseClass {
    @BeforeTest
    public void setValues() {
        testCaseName = "Login test case using UI";
        testDescription ="Test case to validate with valid user";
        testAuthor="Sathish";
        testCategory ="Smoke";
    }


    @Test
    public void testLoginPage(){
        String userName ="demosalesmanager";
        String password ="crmsfa";

        new LoginPage()
                .typeUsername(userName)
                .typePassword(password)
                .clickLogin()
                .clickCRMLink()
                .verifyUserNameDisplayed(userName);
    }
}
