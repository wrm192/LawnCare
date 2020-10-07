package com.redflag.lawncare.common.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ApiCalculator {

    private String baseURL;
    private String param;
    private double area;
    private double obstruction;

    public ApiCalculator(double area, double obstruction) {
        this.area = area;
        this.obstruction = obstruction;
        this.baseURL = "http://127.0.0.1:8080/api/v1/calculations";
        this.param = "area=" + area + "&obstructions=" + obstruction;
    }

    public String returnResult() throws IOException {
        return sendGet(baseURL, param);
    }

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            result = in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null)
                    in.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}