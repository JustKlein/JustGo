package com.example.justgo.Requests;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Keven on 8/26/2017.
 */

public class UltimaRotaAddRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "https://justgodb.000webhostapp.com/ultimoPonto.php";
    private Map<String, String> params;

    public UltimaRotaAddRequest( Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
