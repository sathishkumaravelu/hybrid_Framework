package base;

import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;
// SELENIUM + BROWSER
public interface IBrowserMethods {

    public void launchBrowser(String url, String browserType) throws MalformedURLException;

    public void launchBrowser(String url);

    public WebElement locateElement(String locatorType, String value);

    public List<WebElement> locateElements(String locatorType, String value);

    public void close();

    public void quit();

    public void click(WebElement ele);

    public void typeValue(WebElement ele, String data);

    public boolean isDisplayed(WebElement ele);
}
