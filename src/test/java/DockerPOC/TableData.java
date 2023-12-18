package DockerPOC;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableData {


    @Test
    public void testWebTable() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        //
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='customers']//tr/td[1]"));
        for (WebElement ele : elements
        ) {
            System.out.println(ele.getText());
        }

    }


    @Test
    public void testEndPoint() {
        //endpoint : https://reqres.in/api/users?page=2

        ValidatableResponse all = RestAssured.given().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200).log().all();

    }
}
