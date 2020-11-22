package APITest;

import Api.Apis.ApiGetPostById;
import Api.Base.apiTestingFactory;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class GetAllPostByTests {

    String id;
    ApiGetPostById GetPostsBy;
    apiTestingFactory tester;
    SoftAssert _assert;
    JSONObject tBody = new JSONObject();

    @BeforeMethod
    public void beforeMethod() {
        _assert = new SoftAssert();
        GetPostsBy = new ApiGetPostById();
        tester = new apiTestingFactory();
        id = "1";
    }

    @Test
    public void Check_ResponseCode_AndBody() throws IOException {

        id = "10";
        GetPostsBy.setApiInterface();
        GetPostsBy.setAPIPath("/" + id); //+id);
        tester.setAPI(GetPostsBy);
        Response resp = tester.getExp_Response();

        _assert.assertEquals(resp.statusCode()
                , 200
                , "Status code is : " + resp.statusCode());

        _assert.assertEquals(GetPostsBy.getResponseBody_withParameter(resp, "id")
                , "10"
                , "id is : " + GetPostsBy.getResponseBody_withParameter(resp, "id"));

        _assert.assertEquals(GetPostsBy.getResponseBody_withParameter(resp, "userId")
                , "1"
                , "userId is : " + GetPostsBy.getResponseBody_withParameter(resp, "userId"));

        _assert.assertEquals(GetPostsBy.getResponseBody_withParameter(resp, "title")
                , "optio molestias id quia eum"
                , "title is mismatched with the expected");

        _assert.assertEquals(GetPostsBy.getResponseBody_withParameter(resp, "body")
                , "quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error"
                , "Body is mismatched with the expected");
        _assert.assertAll();
    }

    @Test
    public void Check_404_For_NotFoundElements() throws IOException {
        id = "101";//Only 100 Json objects found
        GetPostsBy.setApiInterface();
        GetPostsBy.setAPIPath("/" + id);
        tester.setAPI(GetPostsBy);
        Response resp = tester.getExp_Response();
        _assert.assertEquals(resp.statusCode()
                , "404"
                , "Status code is : " + resp.statusCode());
    }
}
