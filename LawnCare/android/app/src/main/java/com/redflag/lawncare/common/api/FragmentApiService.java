package com.redflag.lawncare.common.api;

import android.os.AsyncTask;

import androidx.fragment.app.Fragment;

import com.redflag.lawncare.common.api.dto.RequestSetter;
import com.redflag.lawncare.common.api.dto.UpdateFragment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.redflag.lawncare.common.api.ApiConstants.BACKEND_IP;

public abstract class FragmentApiService <T extends Fragment & UpdateFragment, E extends RequestSetter > extends AsyncTask<E, Void, String> {

    private T parent;
    private E request;

    FragmentApiService(T parent, E request) {
        this.parent = parent;
        this.request = request;
    }

    public String returnResult(String path) {
        return sendGet(BACKEND_IP + path);
    }

    public String sendGet(String url) {
        BufferedReader in = null;
        try {
            HttpURLConnection connection =  (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setUseCaches(false);
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            this.request.setRequestParams(osw);
            osw.flush();
            osw.close();
            os.close();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            in.readLine();
            this.parent.updateFragment();
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
        return "SUCCESS";
        //
    }



}
