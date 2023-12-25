package DataProvider;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;

public class DataProviderAPI {

    private static Response response;
    private Faker faker;
    private boolean apiStatus = false;

    public void testData() {
        try {
            response = RestAssured.given().get("https://random-data-api.com/api/v2/users?size=1&response_type=json");
            int statusCode = response.statusCode();
            if(statusCode == 200)
                apiStatus = true;
            else
                apiStatus=false;

            if (!apiStatus){
                System.out.println("API call failed. Using JavaFaker for data generation.");
                generateFakerData();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void generateFakerData() {
        faker = new Faker();
    }

    private String generateUserName() {
        if (apiStatus) {
            return response.getBody().jsonPath().get("username");
        } else {
            // If API failed, use JavaFaker data
            return faker.name().username();
        }
    }

    private String generateFirstName() {
        if (apiStatus) {
            return response.getBody().jsonPath().get("first_name");
        } else {
            // If API failed, use JavaFaker data
            return faker.name().firstName();
        }
    }

    private String generateLastName() {
        if (apiStatus) {
            return response.getBody().jsonPath().get("last_name");
        } else {
            // If API failed, use JavaFaker data
            return faker.name().lastName();
        }
    }

    @DataProvider
    public Object[][] getData() {
        testData();
        Object[][] data = {
                {generateFirstName(), generateLastName(), generateUserName()}
        };
        return data;
    }
}
