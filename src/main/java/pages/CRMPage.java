package pages;

import base.BrowserMethodsImp;
public class CRMPage extends BrowserMethodsImp {

    public LeaftapsDashboard clickCRMLink(){
        getScreenshot();
        click(locateElement("xpath","//*[contains(text(),'CRM/SFA')]"));
        System.out.println("CRM link Clicked");
        reportStep("CRM Link clicked", "pass");
        return new LeaftapsDashboard();
    }
}
