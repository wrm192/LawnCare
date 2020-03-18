package com.redflag.lawncare;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.redflag.lawncare.api.ApiMapperService;
import com.redflag.lawncare.api.ApiRequest;
import com.redflag.lawncare.api.ListApiRequest;
import com.redflag.lawncare.common.models.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        textView1 = findViewById(R.id.textView1);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private Response.Listener<Product> createMyReqSuccessListener() {

        return new Response.Listener<Product>() {
            @Override
            public void onResponse(Product response) {
                System.out.println("this response is");
                textView1.setText("the response is " + response);
            }
        };
    }

    private Response.Listener<JSONArray> listListener () {
        return new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray array) {
                List<Product> prod =  new ApiMapperService<>(Product.class).convertJSONArrayToList(array);
                textView1.setText( "Size is: " + prod.size());
            }
        };
    }

    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
                textView1.setText("in error");
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HttpsURLConnection urlConnection = null;
//                try {
//                    URL url = new URL(ApiConstants.FULL_BASE + "products.json");
//
//                    textView1.setText("request was sent");
//
//                    urlConnection = (HttpsURLConnection) url.openConnection();
//                    textView1.setText("url was opened");
//                    InputStream err = new BufferedInputStream(urlConnection.getErrorStream());
//                    InputStream in = null;
//                    if(err == null){
//
//                        in = new BufferedInputStream(urlConnection.getInputStream());
//                        textView1.setText("in is got");
//                        readStream(in);
//                        textView1.setText("in is done");
//                    }
//                    System.out.println("error isn't null");
//                    readStream(err);
//                }
//                catch (Exception e) {
//                    System.out.println(e);
//                    System.out.println(e.getStackTrace());
//                    System.out.println("in the url creation");
//                }
//                finally { if(urlConnection != null) urlConnection.disconnect();}
//            }
//        });
//        thread.start();

        RequestQueue rq = Volley.newRequestQueue(this);
        System.out.println("~~~~~~hi in options selected");
        rq.start();


        ListApiRequest req = new ListApiRequest(Request.Method.GET, "products",Product.class, this.listListener(), createMyReqErrorListener() );

       /*ApiRequest<Product> req = new ApiRequest<>(Request.Method.GET, "products/4640312590475", Product.class, null,
                createMyReqSuccessListener(), createMyReqErrorListener());*/
        rq.add(req);

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
