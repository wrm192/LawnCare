package com.redflag.lawncare;

import android.os.Bundle;

<<<<<<< HEAD
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
=======
=======
>>>>>>> efac4c7e911bf09d17ac0fa90ac7942a415c511e
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
import android.widget.Button;
import android.content.Intent;

import org.json.JSONArray;
import com.redflag.lawncare.faq.FaqActivity;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView textView1;
    private Button faq;
<<<<<<< HEAD
>>>>>>> FAQ 1.1
=======
>>>>>>> efac4c7e911bf09d17ac0fa90ac7942a415c511e
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
<<<<<<< HEAD
=======

        faq = (Button)findViewById(R.id.faqbutton);

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FaqActivity.class));
            }
        });

        faq = (Button)findViewById(R.id.faqbutton);

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FaqActivity.class));
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
>>>>>>> FAQ 1.1
    }
}
