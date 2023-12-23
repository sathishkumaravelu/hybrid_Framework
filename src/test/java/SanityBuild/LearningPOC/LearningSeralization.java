package SanityBuild.LearningPOC;

import SanityBuild.POJO_.PostBodyCreateBooking;
import SanityBuild.POJO_.ResponsePojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LearningSeralization {

    @Test
    public void createBooking() {

        //endpoint - https://restful-booker.herokuapp.com/booking
        //content-type - application/json
        /*
        {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
         */

        PostBodyCreateBooking bodyPOJO = new PostBodyCreateBooking();
        bodyPOJO.setFirstname("Sathish");
        bodyPOJO.setLastname("Kumaravelu");
        bodyPOJO.setTotalprice(150);
        bodyPOJO.setDepositpaid(true);
        PostBodyCreateBooking.bookingdates obj  = new PostBodyCreateBooking.bookingdates();
        obj.setCheckin("2018-01-01");
        obj.setCheckout("2019-01-01");
        bodyPOJO.setBookingdates(obj);
        bodyPOJO.setAdditionalneeds("Testing POJO");

        Response post = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType("Application/json")
                .body(bodyPOJO)
                .post();
        post.then().statusCode(200);
        post.prettyPrint();

        ResponsePojo responsePojo = post.getBody().as(ResponsePojo.class);
        int bookingid = responsePojo.getBookingid();

        boolean depositpaid = responsePojo.getBooking().isDepositpaid();

        Assert.assertTrue(depositpaid);

    }
}
