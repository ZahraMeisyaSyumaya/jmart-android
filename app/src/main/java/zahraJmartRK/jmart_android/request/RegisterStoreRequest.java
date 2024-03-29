package zahraJmartRK.jmart_android.request;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;



public class RegisterStoreRequest extends StringRequest{
    private Map<String, String> params;

    public RegisterStoreRequest(int id, String name, String address, String phoneNumber, Response.Listener<String> listener, Response.ErrorListener errorListener){
        super(Method.POST, "http://10.0.2.2:7080/account/"+id+"/registerStore", listener, errorListener);
        params = new HashMap<>();
        params.put("name", name);
        params.put("address", address);
        params.put("phoneNumber", phoneNumber);
    }

    public Map<String, String> getParams(){
        return params;
    }
}