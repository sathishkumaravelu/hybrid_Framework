package stepDef;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class LoginPageStepDef  {

    public static RemoteWebDriver driver;

    @Given("Launch browser")
    public void launcBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/main");
    }


    @Given("enter username {string}")
    public void enterUsernameUsername(String userName) {
        driver.findElement(By.id("username")).sendKeys(userName);
    }
    @Given("enter password {string}")
    public void enterPasswordPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @Given("click CRM")
    public void clickCRM() {
       driver.findElement(By.xpath("//*[@type='submit']")).click();
    }
}
