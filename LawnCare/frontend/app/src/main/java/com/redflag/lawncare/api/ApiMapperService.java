package com.redflag.lawncare.api;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.redflag.lawncare.common.models.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    private void printResponse(List<T> list) {
        for (T t : list)
            System.out.println(t);

    }
}
