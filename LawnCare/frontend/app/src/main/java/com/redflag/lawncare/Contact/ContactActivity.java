package com.redflag.lawncare.contact;

import android.os.Bundle;

import com.redflag.lawncare.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends Fragment {
    private String fName;
    private String lName;
    private String phoneNumb;
    private String email;
    private String inquiry;
    private Button submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        EditText fNameInput = container.getRootView().findViewById(R.id.fNameInput);
        EditText lNameInput = container.getRootView().findViewById(R.id.lNameInput);
        EditText phoneNumbInput = container.getRootView().findViewById(R.id.phoneNumberInput);
        EditText emailInput = container.getRootView().findViewById(R.id.emailInput);

        EditText inquiryInput = container.getRootView().findViewById(R.id.inquiryInput);
        submit = container.getRootView().findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName = fNameInput.getText().toString();
                lName = lNameInput.getText().toString();
                phoneNumb = phoneNumbInput.getText().toString();
                email = emailInput.getText().toString();
                inquiry = inquiryInput.getText().toString();

            }
        });

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        return rootView;
        //return super.onCreateView(inflater, container, savedInstanceState);
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contact);

        EditText fNameInput = (EditText)findViewById(R.id.fNameInput);

        EditText lNameInput = (EditText)findViewById(R.id.lNameInput);

        EditText phoneNumbInput = (EditText)findViewById(R.id.phoneNumberInput);

        EditText emailInput = (EditText)findViewById(R.id.emailInput);

        EditText inquiryInput = (EditText)findViewById(R.id.inquiryInput);

        submit = (Button)findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName = fNameInput.getText().toString();
                lName = lNameInput.getText().toString();
                phoneNumb = phoneNumbInput.getText().toString();
                email = emailInput.getText().toString();
                inquiry = inquiryInput.getText().toString();

            }
        });*/

    }
}
/*public class ContactActivity extends AppCompatActivity {
    private String fName;
    private String lName;
    private String phoneNumb;
    private String email;
    private String inquiry;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contact);

        EditText fNameInput = (EditText)findViewById(R.id.fNameInput);

        EditText lNameInput = (EditText)findViewById(R.id.lNameInput);

        EditText phoneNumbInput = (EditText)findViewById(R.id.phoneNumberInput);

        EditText emailInput = (EditText)findViewById(R.id.emailInput);

        EditText inquiryInput = (EditText)findViewById(R.id.inquiryInput);

        submit = (Button)findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName = fNameInput.getText().toString();
                lName = lNameInput.getText().toString();
                phoneNumb = phoneNumbInput.getText().toString();
                email = emailInput.getText().toString();
                inquiry = inquiryInput.getText().toString();

            }
        });

    }
}*/
