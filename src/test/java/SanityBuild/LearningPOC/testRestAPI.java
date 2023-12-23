package SanityBuild.LearningPOC;

import SanityBuild.POJO_.PostBodyCreateBooking;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testRestAPI {

    @Test
    public void  testAPI(){


        Response response = RestAssured.given()
                .baseUri("https://reqres.in/")
                .basePath("api/users/2")
                .get();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

        response.prettyPrint();

        String string = response.getBody().jsonPath().get("data.id").toString();
        Assert.assertEquals(string,"2");


    }

    //@Test
    public void testBookingPost(){

      //  File jsonFile = new File("DataJsonFiles/createBooking.json");

        PostBodyCreateBooking bodyPOJO  = new PostBodyCreateBooking();
        bodyPOJO.setFirstname("Sathish");
        bodyPOJO.setLastname("Kumaravelu");
        bodyPOJO.setTotalprice(150);
        bodyPOJO.setDepositpaid(true);
        PostBodyCreateBooking.bookingdates obj  = new PostBodyCreateBooking.bookingdates();
        obj.setCheckin("2018-01-01");
        obj.setCheckout("2019-01-01");
        bodyPOJO.setBookingdates(obj);
        bodyPOJO.setAdditionalneeds("Testing POJO");


        Response booking = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .contentType("application/json")
                .basePath("booking")
                .body(bodyPOJO)
                .post();

                booking.then().statusCode(200);

                booking.prettyPrint();

        String bookingid = booking.getBody().jsonPath().get("bookingid").toString();
        //checkin
        String checkinValue = booking.getBody().jsonPath().get("booking.bookingdates.checkin").toString();
        System.out.println(bookingid +" - " + checkinValue);



    }
}
