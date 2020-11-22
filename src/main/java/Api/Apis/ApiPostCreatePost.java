package Api.Apis;

import Api.Base.API_Base;
import Api.Base.Int_API;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class ApiPostCreatePost extends API_Base implements Int_API {

    @Override
    public void setHeader() {
        if (getHeader() != null)
            this.list.clear();
        list.add(new Header("Connection", "keep-alive"));
        setheader(new Headers(list));
    }

    @Override
    public void setBody() {
        tBody.put("title", "foo");
        tBody.put("body", "bar");
        tBody.put("userId", "1");
        this.setBody(tBody);
    }

    @Override
    public ApiPostCreatePost setApiInterface() {
        this.setHeader();
        this.setBody();
        return this;
    }
}
