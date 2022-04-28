package algoTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.HeaderCapability;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class JiraIssue implements HeaderCapability {
    public static void main (String[] args){
        String baseUri = "https://dannt.atlassian.net";
        String path = "/rest/api/3/project/API";

        String email = "dannt.c25@gmail.com";
        String apiToken = "LzcIcYkItZFAUxrHrkm98069";
        String  cred = email.concat(":").concat(apiToken);
        byte[] encođeCred = Base64.encodeBase64(cred.getBytes());
        String encodeCredStr = new String(encođeCred);

        RequestSpecification request = given();
        request.baseUri(baseUri);
        request.header(defaultHeader);
        request.header("Authorization", "Basic " + encodeCredStr);

        Response response = request.get(path);
        response.prettyPrint();
    }
}
