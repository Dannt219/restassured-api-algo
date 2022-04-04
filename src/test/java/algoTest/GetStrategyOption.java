package algoTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetStrategyOption {
    @Before
    public  void  init(){
        RestAssured.baseURI = "https://api.tokenize-dev.com/api";
        RestAssured.basePath = "/setting/algo-trading";
    }

    @Test
    public  void getListStrategyOption (){
        Response res = given()
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjI3NjgsInJvbGVOYW1lIjoiUHJlbWl1bSIsInJvbGVUeXBlIjoiVXNlciIsInZlcmlmaWVkIjoxLCJpc3N1ZVRpbWVTdGFtcCI6MTY0ODc5ODk5MDIwMywiaWF0IjoxNjQ4Nzk4OTkwLCJleHAiOjE2NDg4MDI1OTB9.mtAUyoiCpg1W4gFbDiiTkBW8KkUH3DavFGq4A_oPShw")
                .when()
                .get("/strategy-options");

        res.prettyPrint();
        res.then().statusCode(200);
        ResponseBody body = res.getBody();

        System.out.println(" ResponBody is " + body.asString());
    }
}
