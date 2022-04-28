package algoTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Transaction;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class GetAlgoTrading {
    @Before
    public void init() {
        RestAssured.baseURI = "https://api.tokenize-dev.com/api";
        RestAssured.basePath = "/setting";
    }

    @Test
    public void postLogin() {
        Transaction body = new Transaction();
        body.setEmail("");
        body.setPassword("");
        body.setCaptcha("");

        Response res = given()
                .header("Authorization", "")
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post("");
    }
    @Test
    public void getListAlgoTradingSetting() {
        Response res = given()
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjI3NjgsInJvbGVOYW1lIjoiUHJlbWl1bSIsInJvbGVUeXBlIjoiVXNlciIsInZlcmlmaWVkIjp0cnVlLCJpc3N1ZVRpbWVTdGFtcCI6MTY0ODU0MTQ5NjUwMCwiaWF0IjoxNjQ4NTQxNDk2LCJleHAiOjE2NDg1NDUwOTZ9.bI_rXC6C0sM_WMpo6EUzTJTD6gI6GmaivYvxMwAZH3I")
                .when()
                .get("/algo-trading");

        res.prettyPrint();
        res.then().statusCode(200);
    }

}
