package Hooks;

import base.BrowserMethodsImp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends BrowserMethodsImp {


    @BeforeMethod
    public void preCondition(){
        launchBrowser("http://leaftaps.com/opentaps/control/main");
    }

    @AfterMethod
    public void postCondition() {
        close();
    }


}
