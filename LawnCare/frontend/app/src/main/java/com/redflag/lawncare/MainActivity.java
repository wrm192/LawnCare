package com.redflag.lawncare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.redflag.lawncare.common.api.ApiMapperService;
import com.redflag.lawncare.common.api.ListApiRequest;
import com.redflag.lawncare.common.models.Product;
import com.redflag.lawncare.register.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.List;
import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.register.User;


public class MainActivity extends AppCompatActivity {
    TextView textView1;
    private Button toRegister;
    User newUser = new User("","","","","","","","","","","","","","");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);


        toRegister = (Button) findViewById(R.id.registerBtn);
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Register.class);
                startActivityForResult(intent, 1);
            }
        });

        setSupportActionBar(toolbar);

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

    private Response.Listener<JSONArray> listListener() {
        return new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray array) {
                List<Product> prod = new ApiMapperService<>(Product.class).convertJSONArrayToList(array);
                textView1.setText("Size is: " + prod.size());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                //newUser = data.getParcelableExtra("result");
                User user = (User)data.getExtras().getSerializable("result");
                System.out.println(user.toString());
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //code
            }
        }
    }
}

