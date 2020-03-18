package com.redflag.lawncare.api;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.redflag.lawncare.common.ApiConstants;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ApiRequest<T> extends Request<T> {

    private Gson gson = new Gson();
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final Response.Listener<T> listener;

    /**
     *
     * @param method int PASS THE METHOD of GET
     * @param url the url added to the base url
     * @param clazz the entity that the json is being converted to
     * @param headers Map<String, String> of headers added to http requests
     * @param listener What happens when the request is completed (each request will have one of these)
     * @param errorListener What happens when the request has an error (each request will have one of these for now)
     */
    public ApiRequest(int method /* this is the type of http request */, String url, Class<T> clazz, Map<String, String> headers, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, ApiConstants.FULL_BASE + url, errorListener);
        this.clazz = clazz;
        if(headers != null)
            this.headers = headers;
        else {
            this.headers = getAuthHeaders();
        }
        this.listener = listener;
    }

    public Map<String, String> getAuthHeaders () {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("client_id", "cdbefccab875a81af90a633589bc776e" );
        headers.put("client_secret", "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" );
        headers.put("X-Shopify-Access-Token", "b9cfc6fa6e63b0372898af0510628134");
        return headers;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? this.headers : super.getHeaders();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        System.out.println("@@@#@#@#@#@in parse network response");
        try {
            JSONObject ob = new JSONObject(new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers)));

            return Response.success(
                    gson.fromJson(ob.optString(ob.keys().next()), clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        } catch (Exception e){
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

}
