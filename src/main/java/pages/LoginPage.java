package pages;
import base.BrowserMethodsImp;

public class LoginPage extends BrowserMethodsImp {

    public LoginPage typeUsername(String username){
        typeValue(locateElement("id","username"),username);
        System.out.println("user name entered successfully");
        reportStep(username+" Username is entered successfully", "pass");
        return this;
    }
    public LoginPage typePassword(String password){
        typeValue(locateElement("id","password"),password);
        System.out.println("password entered successfully");
        reportStep(password+" Password is entered successfully", "pass");
        return this;
    }

    public CRMPage clickLogin(){
        getScreenshot();
        click(locateElement("xpath","//*[@type='submit']"));
        System.out.println("Submit button clicked");
        reportStep("login Button clicked", "pass");
        return new CRMPage();
    }

}
