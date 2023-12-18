package DockerPOC;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TC_SampleDockerRun {

    private static void executeJavaScriptClick(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


    @Test
    public void chrometest() throws Exception {
        URL dockerUrl = new URL("http://localhost:4444/");
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver driver = new RemoteWebDriver(dockerUrl, options);
        driver.get("http://leaftaps.com/opentaps/control/main");
        // Set an implicit wait for 20 seconds
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        //driver.findElement(By.id("logout")).click();
        executeJavaScriptClick(driver,driver.findElement(By.id("logout")));
        driver.quit();
    }

    }
