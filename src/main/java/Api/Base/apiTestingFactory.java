package Api.Base;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class apiTestingFactory {

    API_Base API;

    public apiTestingFactory() {
    }

    public void setAPI(API_Base API) {
        this.API = API;
    }

    public Response getExp_Response()//used
    {
        Response resp = given().
                headers(API.getHeader()).
                body(API.getBody()).
                when().
                contentType(ContentType.JSON).
                get(API.getBasePath()).
                then().
                extract().
                response();
        System.out.println(API.getBasePath() + " API body : " + API.getBody());

        try {
            Thread.sleep(10000);// min wait between login and logout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(API.getAPIPath() + " API response : " + resp.getBody().prettyPrint());
        return resp;
    }

    public Response postExp_Response() {
        Response resp = given().
                headers(API.getHeader()).
                body(API.getBody()).
                when().
                contentType(API.getJsonFormat()).
                post(API.getBasePath() + API.getAPIPath());
        System.out.println(API.getAPIPath() + " API body : " + API.getBody());

        try {
            Thread.sleep(10000);// min wait between login and logout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(API.getAPIPath() + " API response : " + resp.asString());
        return resp;
    }
}

