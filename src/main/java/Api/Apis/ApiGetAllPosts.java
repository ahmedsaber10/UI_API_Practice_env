package Api.Apis;

import Api.Base.API_Base;
import Api.Base.Int_API;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.io.IOException;

public class ApiGetAllPosts extends API_Base implements Int_API {

    @Override
    public void setHeader() {
        if (getHeader() != null)
            this.list.clear();
        list.add(new Header("Connection", "keep-alive"));
        list.add(new Header("Accept-Encoding", " 'gzip','deflate','br'"));
        setheader(new Headers(list));
    }

    @Override
    public void setBody() throws IOException {

        tBody.put("", "");
        this.setBody(tBody);
    }

    @Override
    public ApiGetAllPosts setApiInterface() throws IOException {
        this.setHeader();
        this.setBody();
        return this;
    }

}
