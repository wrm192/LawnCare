package com.redflag.lawncare.Contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.redflag.lawncare.R;

public class ContactFragment extends Fragment {
    private String name;
    private String phoneNumb;
    private String email;
    private String inquiry;
    private Button submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);


        EditText fNameInput = rootView.findViewById(R.id.fNameInput);
        EditText phoneNumbInput = rootView.findViewById(R.id.phoneNumberInput);
        EditText emailInput = rootView.findViewById(R.id.emailInput);

        EditText inquiryInput = rootView.findViewById(R.id.inquiryInput);
        submit = rootView.findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = fNameInput.getText().toString();
                phoneNumb = phoneNumbInput.getText().toString();
                email = emailInput.getText().toString();
                inquiry = inquiryInput.getText().toString();

            }
        });



        return rootView;


    }
}
