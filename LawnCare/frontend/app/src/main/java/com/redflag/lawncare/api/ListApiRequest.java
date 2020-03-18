package com.redflag.lawncare.api;


import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;

import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.redflag.lawncare.BuildConfig;
import com.redflag.lawncare.common.ApiConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListApiRequest<T> extends Request {

    private Map<String, String> headers;
    private Class<T> clazz;
    private List<T> responseList;

    private final Response.Listener<JSONArray> listener;

    public ListApiRequest(int method, String url, Class<T> clazz, Response.Listener<JSONArray> listener, @Nullable Response.ErrorListener eListener) {
        super(method, ApiConstants.FULL_BASE + url, eListener);
        this.listener = listener;
        this.headers = getAuthHeaders();
        this.clazz = clazz;
    }


    /*

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
     */

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? this.headers : super.getHeaders();
    }



    public Map<String, String> getAuthHeaders () {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("client_id", BuildConfig.API_KEY  );
        headers.put("client_secret", BuildConfig.API_SSL );
        headers.put("X-Shopify-Access-Token", BuildConfig.API_TOKEN );
        return headers;
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {
            JSONObject ob = new JSONObject(new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers)));

            JSONArray array = new JSONArray(ob.optString(ob.keys().next()));
            return Response.success(array, HttpHeaderParser.parseCacheHeaders(response));
        }catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        } catch (Exception e){
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(Object response) {

        listener.onResponse((JSONArray) response);

    }



    public List<T> getResponse() {
        return this.responseList;
    }
}
