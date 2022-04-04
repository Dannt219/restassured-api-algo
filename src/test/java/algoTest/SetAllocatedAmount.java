package algoTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class SetAllocatedAmount {
    @Before
    public  void  init () {
        RestAssured.baseURI = "https://api.tokenize-dev.com/api";
        RestAssured.basePath = "/setting";
    }
    @Test
    public void setAllocatedAmount() {
        Transaction transaction = new Transaction();
        transaction.setMarketCode("SGD-ADA");
        transaction.setStatus("enabled");
        transaction.setAmountSize(1300);
        transaction.setStrategy("trend");

        Response res = given()
                .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjI3NjgsInJvbGVOYW1lIjoiUHJlbWl1bSIsInJvbGVUeXBlIjoiVXNlciIsInZlcmlmaWVkIjp0cnVlLCJpc3N1ZVRpbWVTdGFtcCI6MTY0ODU0MTQ5NjUwMCwiaWF0IjoxNjQ4NTQxNDk2LCJleHAiOjE2NDg1NDUwOTZ9.bI_rXC6C0sM_WMpo6EUzTJTD6gI6GmaivYvxMwAZH3I")
                .contentType(ContentType.JSON)
                .when()
                .body(transaction)
                .post("/algo-trading");
        res.prettyPrint();
        res.then().statusCode(200).body("message", equalTo(""));
    }
}
