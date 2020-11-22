package APITest;

import Api.Apis.ApiGetPostById;
import Api.Apis.ApiPostCreatePost;
import Api.Base.apiTestingFactory;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class PostCreatePostTests {

    ApiPostCreatePost createPost;
    ApiGetPostById GetPostsBy;
    apiTestingFactory tester;
    SoftAssert _assert;

    @BeforeMethod
    public void beforeMethod() {
        _assert = new SoftAssert();
        createPost = new ApiPostCreatePost();
        tester = new apiTestingFactory();
        GetPostsBy = new ApiGetPostById();
    }

    @Test
    public void Check_ResponseCode_AndBody() {
        JSONObject tBody = new JSONObject();
        tBody.put("title", "test title");
        tBody.put("body", "test body");
        tBody.put("userId", "test user id");
        tBody.put("id", "101");
        createPost.setApiInterface();
        createPost.setBody(tBody);
        tester.setAPI(createPost);
        Response resp = tester.postExp_Response();
        _assert.assertEquals(resp.statusCode()
                , 201
                , "Status code is : " + resp.statusCode());
        _assert.assertEquals(createPost.getResponseBody_withParameter(resp, "id")
                , tBody.get("id")
                , "id is : " + resp.statusCode());
        _assert.assertEquals(createPost.getResponseBody_withParameter(resp, "userId"),
                tBody.get("userId"),
                "userId is : " + createPost.getResponseBody_withParameter(resp, "userId"));
        _assert.assertEquals(createPost.getResponseBody_withParameter(resp, "title"),
                tBody.get("title"),
                "title is mismatched with the expected");
        _assert.assertEquals(createPost.getResponseBody_withParameter(resp, "body")
                , tBody.get("body")
                , "Body is mismatched with the expected");
        _assert.assertAll();
    }

    @Test
    public void Check_Body_NotAllParameter_AndGetTheCreatedAd() throws IOException {
        JSONObject tBody = new JSONObject();
        tBody.put("title", "test title");
        createPost.setApiInterface();
        createPost.setBody(tBody);
        tester.setAPI(createPost);
        Response resp = tester.postExp_Response();
        _assert.assertEquals(resp.statusCode()
                , 201
                , "Status code is : " + resp.statusCode());
        _assert.assertEquals(createPost.getResponseBody_withParameter(resp, "id")
                , "101"
                , "id is : " + resp.statusCode());
        _assert.assertEquals(createPost.getResponseBody_withParameter(resp, "userId"),
                "not found",
                "userId is not null");
        _assert.assertEquals(createPost.getResponseBody_withParameter(resp, "title"),
                tBody.get("title"),
                "title is mismatched with the expected");
        _assert.assertEquals(createPost.getResponseBody_withParameter(resp, "body")
                , "not found"
                , "Body is not null");

        String id = createPost.getResponseBody_withParameter(resp, "id");
        GetPostsBy.setApiInterface();
        GetPostsBy.setAPIPath("/" + id); //+id);
        tester.setAPI(GetPostsBy);
        resp = tester.getExp_Response();
        _assert.assertEquals(resp.statusCode()
                , 201
                , "Status code is : " + resp.statusCode());
        _assert.assertEquals(GetPostsBy.getResponseBody_withParameter(resp, "id")
                , "101"
                , "id is : " + resp.statusCode());
        _assert.assertAll();
    }

}
