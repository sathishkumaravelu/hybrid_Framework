package pages;

import base.BrowserMethodsImp;

public class LeaftapsDashboard extends BrowserMethodsImp {

    public LeaftapsDashboard verifyUserNameDisplayed(String usernaame){
        if(verifyTextDisplayed(locateElement("xpath","//div[@class='insideHeaderText']/b"))){
            String actualUserValue = getTextValue(locateElement("xpath", "//div[@class='insideHeaderText']/b"));
            if(actualUserValue.equalsIgnoreCase( usernaame)){
                System.out.println("user logged in correctly");
            }else {
                System.out.println("Different user logged in ");
            }
            getScreenshot();
            reportStep("Loged in with correct user", "pass");
        }
        return this;
    }

    public LeadPage clickLeadMenu(){
        click(locateElement("xpath","//a[text()='Leads']"));
        reportStep("Lead Button clicked", "pass");
        return new LeadPage();
    }
}
