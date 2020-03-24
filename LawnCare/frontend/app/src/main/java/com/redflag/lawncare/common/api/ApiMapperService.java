package com.redflag.lawncare.common.api;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class maps to list
 */
public class ApiMapperService<T> {

    private final Class<T> clazz;
    private  Gson gson = new Gson();

    public ApiMapperService(Class<T> clazz) {
        this.clazz = clazz;
    }


    public List<T> convertJSONArrayToList(JSONArray array) {
        List<T> list = new ArrayList<>();

        try {
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = (JSONObject) array.get(i);
                list.add(gson.fromJson(obj.toString(), clazz));
            }
            printResponse(list); // for testing
        } catch (Exception e) {
            System.out.println("Exception during parsing");
        }

        return list;
    }


    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        };
    }


    /**
     * For testing
     */
    private void printResponse(List<T> list) {
        for (T t : list)
            System.out.println(t);

    }
}
