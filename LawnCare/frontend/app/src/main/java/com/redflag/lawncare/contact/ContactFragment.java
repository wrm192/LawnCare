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

import com.google.android.material.textfield.TextInputLayout;
import com.redflag.lawncare.R;

public class ContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);


        TextInputLayout fNameInput = rootView.findViewById(R.id.name);
        TextInputLayout phoneNumbInput = rootView.findViewById(R.id.phoneNum);
        TextInputLayout emailInput = rootView.findViewById(R.id.email);

        EditText inquiryInput = rootView.findViewById(R.id.inquiryInput);

        Button submit = rootView.findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = fNameInput.getEditText();
                EditText phoneNumb = phoneNumbInput.getEditText();
                EditText email = emailInput.getEditText();
                String inquiry = inquiryInput.getText().toString();

            }
        });



        return rootView;


    }
}
