package Api.Apis;

import Api.Base.API_Base;
import Api.Base.Int_API;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.io.IOException;

public class ApiGetPostById extends API_Base implements Int_API {

    @Override
    public void setHeader() {
        if (getHeader() != null)
            this.list.clear();
        list.add(new Header("Cookie", "__cfduid=dff1b66e7a2fd3364a41857bed5408f6c1605952103"));
        list.add(new Header("Connection", "keep-alive"));
        list.add(new Header("Accept-Encoding", "gzip, deflate, br"));
        setheader(new Headers(list));
    }

    @Override
    public void setBody() throws IOException {
        tBody.put("", "");
        this.setBody(tBody);
    }

    @Override
    public ApiGetPostById setApiInterface() throws IOException {
        this.setHeader();
        this.setBody();
        return this;
    }

}
