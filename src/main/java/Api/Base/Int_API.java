package Api.Base;


import org.json.JSONObject;

import java.io.IOException;

public interface Int_API {

    JSONObject tBody = new JSONObject();

    void setHeader() throws IOException;

    void setBody() throws IOException;

    API_Base setApiInterface() throws IOException;

}
