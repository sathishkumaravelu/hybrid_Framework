package SanityBuild.POJO_;

import lombok.Data;

@Data
public class PostBodyCreateBooking {

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


    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;

    private bookingdates bookingdates;

    @Data
    public static class bookingdates{
        private String checkin;
        private String checkout;
    }

    private String additionalneeds;
}
