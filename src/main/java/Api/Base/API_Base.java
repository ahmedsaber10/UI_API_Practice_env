package Api.Base;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class API_Base {
    private static final ContentType jsonFormat = ContentType.JSON;
    protected final List<Header> list = new LinkedList<Header>();
    JSONObject Body = new JSONObject();
    private String APIPath = "";
    private Headers mainHeader;//= new Headers( list);

    public API_Base() {
    }

    public String getAPIPath() {
        return APIPath;
    }

    public void setAPIPath(String APIPath) {
        this.APIPath = APIPath;
    }

    public ContentType getJsonFormat() {
        return jsonFormat;
    }

    public String getBody() {
        return Body.toString();
    }

    public void setBody(JSONObject body) {
        Body = body;
    }

    public Headers getHeader() {
        return mainHeader;
    }

    public void setheader(Headers headerMap) {
        mainHeader = headerMap;
    }

    public void setHeader() {
//        if (mainHeader != null)
//            this.list.clear();//Connection
////        this.list.add(new Header("Connection", "keep-alive"));
//        this.list.add(APIConfig.header_Authorization);
//        this.list.add(APIConfig.header_Device);
//        this.list.add(APIConfig.header_Ver);
//        this.list.add(APIConfig.header_HMAC);
//        this.list.add(APIConfig.header_Content_Type);
//        setheader(new Headers(list));
    }

    public String getBasePath() {
        return Api_Path.BASE_PATH + APIPath;
    }


    public Response getresponse() {
        Response resp = given().
                headers(mainHeader).
                body(Body).
                when().
                contentType(getJsonFormat()).
                post(getBasePath() + APIPath);

        JsonPath jsonPathEvaluator = resp.jsonPath();
        String status = jsonPathEvaluator.get("status").toString();
        System.out.println(" API response : " + resp.asString());
        return resp;
    }

    public String getresponsestatus(Response resp) {
        JsonPath jsonPathEvaluator = resp.jsonPath();
        String status = jsonPathEvaluator.get("status").toString();
        return (status);
    }

    public String getResponseBody_withParameter(Response resp, String parameter) {
        JsonPath jsonPathEvaluator = resp.jsonPath();
        try {
            String param = jsonPathEvaluator.get(parameter).toString();
            return (param);
        } catch (Exception e) {
            return "not found";
        }

    }

}
