package com.redflag.lawncare.register;

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
import com.redflag.lawncare.MainActivity;
import com.redflag.lawncare.R;
import com.redflag.lawncare.common.api.ApiMapperService;
import com.redflag.lawncare.common.api.ListApiRequest;
import com.redflag.lawncare.common.models.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.List;


public class Register extends AppCompatActivity {

    private Button register;
    private String fName;
    private String lName;
    private String homePhoneNumb;
    private String workPhoneNumb;
    private String email;
    private String password;
    private String passwordConfirm;
    private String userType;
    private String address1;
    private String address2;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText fNameInput = (EditText)findViewById(R.id.fNameInput);

        EditText lNameInput = (EditText)findViewById(R.id.lNameInput);

        EditText homePhoneNumbInput = (EditText)findViewById(R.id.homePhoneNumbInput);

        EditText workPhoneNumbInput = (EditText)findViewById(R.id.workPhoneNumbInput);

        EditText emailInput = (EditText)findViewById(R.id.emailInput);

        EditText passwordInput = (EditText)findViewById(R.id.passwordInput);

        EditText passwordConfirmInput = (EditText)findViewById(R.id.pwConfirmInput);

        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);

        EditText address1Input = (EditText)findViewById(R.id.add1Input);

        EditText address2Input = (EditText)findViewById(R.id.add2Input);

        EditText postalCodeInput = (EditText)findViewById(R.id.postalCodeInput);

        EditText cityInput = (EditText)findViewById(R.id.cityInput);

        EditText provinceInput = (EditText)findViewById(R.id.provinceInput);

        EditText countryInput = (EditText)findViewById(R.id.countryInput);


        register = (Button)findViewById(R.id.submitBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName = fNameInput.getText().toString();

                lName = lNameInput.getText().toString();

                homePhoneNumb = homePhoneNumbInput.getText().toString();

                workPhoneNumb = workPhoneNumbInput.getText().toString();

                email = emailInput.getText().toString();

                password = passwordInput.getText().toString();

                passwordConfirm = passwordConfirmInput.getText().toString();

                int selected = rg.getCheckedRadioButtonId();
                RadioButton userTypeSelected = (RadioButton)findViewById(selected);
                userType = userTypeSelected.getText().toString();

                address1 = address1Input.getText().toString();

                address2 = address2Input.getText().toString();

                postalCode = postalCodeInput.getText().toString();

                city = cityInput.getText().toString();

                province = provinceInput.getText().toString();

                country = countryInput.getText().toString();



                /*System.out.println("fname: " + fName + "\nlName: " + lName + "\nhomephone: " + homePhoneNumb
                + "\nworkphone: " + workPhoneNumb + "\nemail: " + email + "\npassword: " + password +
                "\npasswordconfirm: " + passwordConfirm + "\nusertype: " + userType + "\naddress1: " + address1
                + "\naddress2:" + address2 + "\npostalcode: " + postalCode + "\ncity: " + city + "\nprovince: " +
                province + "\ncountry: " + country);

                Intent intent = new Intent(v.getContext(), Register.class);
                startActivityForResult(intent, 0);*/

                User user = new User(fName,lName,homePhoneNumb,workPhoneNumb,email,password,passwordConfirm,userType,address1,address2,postalCode,city
                ,province,country);

                //System.out.println(user.toString());

                Intent returnIntent = new Intent(v.getContext(), MainActivity.class);
                returnIntent.putExtra("result",user);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        });

    }
}
