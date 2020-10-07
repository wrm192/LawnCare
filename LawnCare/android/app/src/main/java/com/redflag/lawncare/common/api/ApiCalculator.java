
package com.redflag.lawncare.common.api;

import android.os.AsyncTask;

import androidx.fragment.app.Fragment;

import com.redflag.lawncare.calculation.CalculationFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ApiCalculator extends AsyncTask<String, Void , String> {

    private String baseURL;
    private String param;
    private double area;
    private double obstruction;
    private CalculationFragment parent;

    public ApiCalculator(CalculationFragment parent, double area, double obstruction) {
        this.parent = parent;
        this.area = area;
        this.obstruction = obstruction;
        this.baseURL = "http://10.0.0.44:8080/api/v1/calculations";
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

    public void updateValues(double area, double obstruction) {
        this.area = area;
        this.obstruction = obstruction;
    }

    @Override
    protected void onPostExecute(String result){
        parent.updateLabel(result);
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            String result = this.returnResult();
            System.out.println(result);
            return result;
        } catch (Exception e) {
            return "API failed";
        }
    }
}