package com.redflag.lawncare.book;

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

public class BookNowFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_booknow,
                container, false);

        Button button = view.findViewById(R.id.bookNowButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("button pressed");

                EditText address = view.findViewById(R.id.address);
                EditText phoneNumber = view.findViewById(R.id.phoneNum);
                EditText name = view.findViewById(R.id.name);

                if(address == null || phoneNumber == null || name == null ||
                        "".equals(address.getText().toString())  ||  "".equals(name.getText().toString()) || "".equals(phoneNumber.getText().toString())) {
                    System.out.println("in error");
                    //TODO error, not sure how to do this properly.
                }else {
                    System.out.println(address.getText().toString() + phoneNumber.getText().toString() + name.getText().toString());
                    //TODO Email support@ezmow.ca
                }
            }
        });

        return view;
    }




}
