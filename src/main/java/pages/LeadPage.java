package pages;

import base.BrowserMethodsImp;

public class LeadPage extends BrowserMethodsImp {

    public LeadPage clickCreateLead(){
        click(locateElement("xpath","//a[text()='Create Lead']"));
        reportStep("CreateLead Button Clicked successfully", "pass");
        return this;
    }

    public LeadPage enterCompanyName(String companyName){
        typeValue(locateElement("id","createLeadForm_companyName"),companyName);
        reportStep("company Name entered successfully", "pass");
        return this;
    }

    public LeadPage enterFirstName(String firstName){
        typeValue(locateElement("id","createLeadForm_firstName"),firstName);
        reportStep("First Name entered successfully", "pass");
        return this;
    }

    public LeadPage enterLastName(String lastName){
        typeValue(locateElement("id","createLeadForm_lastName"),lastName);
        reportStep("Last Name entered successfully", "pass");
        return this;
    }

    public LeadPage clickSubmitLead(){
        click(locateElement("xpath","//input[@value='Create Lead']"));
        getScreenshot();
        return this;
    }

}
