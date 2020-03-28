package com.redflag.lawncare;

import android.os.Bundle;

import com.android.volley.Response;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.redflag.lawncare.common.api.ApiMapperService;
import com.redflag.lawncare.common.models.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;

import org.json.JSONArray;
import com.redflag.lawncare.faq.Faq;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView textView1;
    private Button faq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        faq = (Button)findViewById(R.id.faqbutton);

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Faq.class));
            }
        });

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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
