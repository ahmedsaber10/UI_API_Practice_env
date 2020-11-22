package APITest;

import Api.Apis.ApiGetAllPosts;
import Api.Base.apiTestingFactory;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class GetAllPostsTests {

    ApiGetAllPosts GetAllPosts;
    apiTestingFactory tester;
    SoftAssert _assert;

    @BeforeMethod
    public void beforeMethod() {
        _assert = new SoftAssert();
        GetAllPosts = new ApiGetAllPosts();
        tester = new apiTestingFactory();
    }

    @Test
    public void Check_ResponseCode_AndBody() throws IOException {

        GetAllPosts.setApiInterface();
        tester.setAPI(GetAllPosts);
        Response resp = tester.getExp_Response();

        _assert.assertEquals(resp.statusCode()
                , 200
                , "Status code is : " + resp.statusCode());

        _assert.assertEquals(GetAllPosts.getResponseBody_withParameter(resp, "id[0]")
                , "1"
                , "id is : " + resp.statusCode());

        _assert.assertEquals(GetAllPosts.getResponseBody_withParameter(resp, "userId[0]"),
                "1",
                "userId is : " + GetAllPosts.getResponseBody_withParameter(resp, "userId[0]"));

        _assert.assertEquals(GetAllPosts.getResponseBody_withParameter(resp, "title[0]"),
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "title is mismatched with the expected");

        _assert.assertEquals(GetAllPosts.getResponseBody_withParameter(resp, "body[0]")
                , "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
                , "Body is mismatched with the expected");
        _assert.assertAll();
    }

}
