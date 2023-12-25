package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Reporter;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

public class BrowserMethodsImp extends Reporter implements IBrowserMethods  {

    private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
    private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();

    public void setWait() {
        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
    }

    public WebDriverWait getWait() {
        return wait.get();
    }

    public RemoteWebDriver getDriver() {
        return remoteWebdriver.get();
    }

    public void setDriver(String browser) throws MalformedURLException {
        switch (browser) {
            case "chrome":
               //git stat: WebDriverManager.chromedriver().setup();
                ChromeOptions opt = new ChromeOptions();
                opt.addArguments("--no-sandbox");
                opt.addArguments("--disable-dev-shm-usage");
                opt.addArguments("--disable-notifications");
                opt.addArguments("--headless");
                remoteWebdriver.set(new ChromeDriver(opt));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                remoteWebdriver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                remoteWebdriver.set(new EdgeDriver());
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                remoteWebdriver.set(new InternetExplorerDriver());
            default:
                break;
        }
    }

    public void launchBrowser(String url, String browserType) {
        try {
            if (browserType.equalsIgnoreCase("chrome")) {
                setDriver("chrome");
            } else if (browserType.equalsIgnoreCase("firefox")) {
                setDriver("firefox");
            } else if (browserType.equalsIgnoreCase("edge")) {
                setDriver("edge");
            } else if (browserType.equalsIgnoreCase("ie")) {
                setDriver("ie");
            }
            System.out.println("Browser launched with url" + url + " in " + browserType);
            setWait();
            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            getDriver().get(url);
        } catch (WebDriverException e) {
            e.printStackTrace();
            throw new RuntimeException("See the reporter for details.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("See the reporter for details.");
        }
    }


    public void launchBrowser(String url) {
        try {
            setDriver("chrome");
            setWait();
            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            getDriver().get(url);
            System.out.println("Browser launched with url" + url + " in chrome");

        } catch (WebDriverException e) {
            e.printStackTrace();
            throw new RuntimeException("See the reporter for details.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("See the reporter for details.");
        }
    }


    public WebElement locateElement(String locatorType, String value) {
        try {
            switch (locatorType.toLowerCase()) {
                case "classname":
                    return getDriver().findElement(By.className(value));
                case "css":
                    return getDriver().findElement(By.cssSelector(value));
                case "id":
                    return getDriver().findElement(By.id(value));
                case "link_text":
                    return getDriver().findElement(By.linkText(value));
                case "name":
                    return getDriver().findElement(By.name(value));
                case "partial_link":
                    return getDriver().findElement(By.partialLinkText(value));
                case "tagname":
                    return getDriver().findElement(By.tagName(value));
                case "xpath":
                    return getDriver().findElement(By.xpath(value));
                default:
                    System.err.println("Locator is not Valid");
                    break;
            }
        } catch (NoSuchElementException e) {
            System.out.println(("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
                    + e.getMessage() + "fail"));
            throw new RuntimeException("See the reporter for details.");
        } catch (Exception e) {
            System.out.println(("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
                    + e.getMessage() + "fail"));

            throw new RuntimeException("See the reporter for details.");
        }
        return null;

    }


    public List<WebElement> locateElements(String locatorType, String value) {
        try {
            switch (locatorType.toLowerCase()) {
                case "classname":
                    return getDriver().findElements(By.className(value));
                case "css":
                    return getDriver().findElements(By.cssSelector(value));
                case "id":
                    return getDriver().findElements(By.id(value));
                case "link_text":
                    return getDriver().findElements(By.linkText(value));
                case "name":
                    return getDriver().findElements(By.name(value));
                case "partial_link":
                    return getDriver().findElements(By.partialLinkText(value));
                case "tagname":
                    return getDriver().findElements(By.tagName(value));
                case "xpath":
                    return getDriver().findElements(By.xpath(value));
                default:
                    System.err.println("Locator is not Valid");
                    break;
            }
        } catch (NoSuchElementException e) {
            System.out.println(("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
                    + e.getMessage() + "fail"));
        } catch (Exception e) {
            System.out.println(("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
                    + e.getMessage() + "fail"));
            throw new RuntimeException("See the reporter for details.");
        }
        return null;
    }


    public void close() {
        try {
            getDriver().close();
            System.out.println(("Browser is closed"));
        } catch (Exception e) {
            System.out.println(("Browser cannot be closed " + e.getMessage() + "fail" + false));
            throw new RuntimeException("See the reporter for details.");
        }
    }

    public void quit() {
        try {
            getDriver().quit();
            System.out.println(("Browser is closed"));
        } catch (Exception e) {
            System.out.println(("Browser cannot be closed " + e.getMessage() + "fail" + false));
            throw new RuntimeException("See the reporter for details.");
        }
    }


    public void click(WebElement ele) {
        String text = "";
        try {
            if (ele.isDisplayed()) {
                getWait().until(ExpectedConditions.elementToBeClickable(ele));
                text = ele.getText();
                ele.click();
            }
        } catch (StaleElementReferenceException e) {
            System.err.println(e);
            System.out.println("element " + text + " " + ele + "could not be clicked" + e.getMessage());
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("element " + text + " " + ele + "could not be clicked" + e.getMessage());
            throw new RuntimeException("See the reporter for details.");
        }
    }


    public void typeValue(WebElement ele, String data) {
        try {
            if (ele.isDisplayed()) {
                ele.clear();
                ele.sendKeys(data);
                System.out.println("Entered value '" + data + "' into the element");
            }
        } catch (StaleElementReferenceException e) {
            System.err.println(e);
            System.out.println("Element " + ele + " could not be typed with value '" + data + "' " + e.getMessage());
            throw new RuntimeException("See the reporter for details.");
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Element " + ele + " could not be typed with value '" + data + "' " + e.getMessage());
            throw new RuntimeException("See the reporter for details.");
        }
    }


    public boolean verifyTextDisplayed(WebElement ele) {
       boolean status = false;
        try {
            status = ele.isDisplayed();
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Element " + ele + " is not able to found due to " + "' " + e.getMessage());
            throw new RuntimeException("See the reporter for details.");
        }
        return status;
    }

    public String getTextValue(WebElement ele){
        try {
            if (ele.isDisplayed()) {
                return ele.getText();
            }
        } catch (StaleElementReferenceException e) {
            System.err.println(e);
            System.out.println("Element " + ele + " is not able to retrieve text due to " + "' " + e.getMessage());
            throw new RuntimeException("See the reporter for details.");
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Element " + ele + " is not able to retrieve text due to " + "' " + e.getMessage());
            throw new RuntimeException("See the reporter for details.");
        }
        return null;
    }

    public void getScreenshot(){
        try{
            String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
            String fileName = "SS" + formattedDateTime;
            File File = ((TakesScreenshot)getDriver())
                    .getScreenshotAs(OutputType.FILE);
            // Ensure the directory exists, create it if not
            File directory = new File("./Screenshot/");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            FileUtils.copyFile(File,
                    new File("./Screenshot/"
                            + fileName + ".jpeg"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isDisplayed(WebElement ele) {
        try {
            return ele.isDisplayed();
        }catch ( Exception e){
            System.out.println("Element " + ele + " is not displayed due to "+ e.getMessage());
            throw new RuntimeException("See the reporter for details.");
        }
    }
}
