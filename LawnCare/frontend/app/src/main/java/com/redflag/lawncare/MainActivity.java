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
import android.widget.Button;
import android.content.Intent;

import org.json.JSONArray;
import com.redflag.lawncare.faq.FaqActivity;
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

        faq = (Button) findViewById(R.id.faqbutton);

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FaqActivity.class));
            }
        });

        faq = (Button) findViewById(R.id.faqbutton);

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FaqActivity.class));
            }
        });

    }
}
