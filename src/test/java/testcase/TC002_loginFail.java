package testcase;

import Hooks.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LeaftapsDashboard;
import pages.LoginPage;

public class TC002_loginFail extends BaseClass {

    @BeforeTest
    public void setValues() {
        testCaseName = "Login test case using UI";
        testDescription ="Test case to validate with invalid user";
        testAuthor="Sathish";
        testCategory ="Smoke";
    }
    @Test(priority = 99999)
    public void testLoginPage(){
        String userName ="demosalesmanager";
        String password ="crmsfa";

        LeaftapsDashboard leaftapsDashboard = new LoginPage()
                .typeUsername(userName)
                .typePassword("sat")
                .clickLogin()
                .clickCRMLink()
                .verifyUserNameDisplayed(userName);
    }
}
