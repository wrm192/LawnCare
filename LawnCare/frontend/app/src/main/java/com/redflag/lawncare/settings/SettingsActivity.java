package com.redflag.lawncare.settings;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.R;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity{

    private Locale french = new Locale("fr");
    private Locale english = new Locale("en-us");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner dropdown = findViewById(R.id.spinner);

        String[] locales = new String[] {" ", "English", "French"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locales);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("item selected");
                String val = (String)parent.getItemAtPosition(position);
                if(val.equals("French")){
                    Locale.setDefault(french);
                    Configuration conig = getBaseContext().getResources().getConfiguration();
                    conig.setLocale(french);
                    getBaseContext().getResources().updateConfiguration(conig, getBaseContext().getResources().getDisplayMetrics());
                    startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                } else if(val.equals("English"))  {
                    Locale.setDefault(english);
                    Configuration conig = getBaseContext().getResources().getConfiguration();
                    conig.setLocale(english);
                    getBaseContext().getResources().updateConfiguration(conig, getBaseContext().getResources().getDisplayMetrics());
                    startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
