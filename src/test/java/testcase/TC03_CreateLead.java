package testcase;

import DataProvider.DataProviderAPI;
import Hooks.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC03_CreateLead extends BaseClass {
    @BeforeTest
    public void setValues() {
        testCaseName = "Create lead using UI";
        testDescription ="Test case to create lead";
        testAuthor="Sathish";
        testCategory ="Smoke";
    }


    @Test(dataProvider = "getData",dataProviderClass = DataProviderAPI.class)
    public void testCreateLead(String firstName, String lastName, String companyName){
        new LoginPage()
                .typeUsername("demosalesmanager")
                .typePassword("crmsfa")
                .clickLogin()
                .clickCRMLink()
                .clickLeadMenu()
                .clickCreateLead()
                .enterCompanyName(companyName)
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .clickSubmitLead();
    }
}
