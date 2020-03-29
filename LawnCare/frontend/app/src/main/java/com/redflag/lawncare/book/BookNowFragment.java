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

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.redflag.lawncare.R;
import com.redflag.lawncare.common.recaptcha.VerificationActivity;

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
                    VerificationActivity va = new VerificationActivity(new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                        @Override
                        public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                            // Indicates communication with reCAPTCHA service was
                            // successful.
                            String userResponseToken = response.getTokenResult();
                            System.out.println("in suc");
                            if (!userResponseToken.isEmpty()) {
                                // Validate the user response token using the
                                // reCAPTCHA siteverify API.
                            }
                        }
                    }, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if (e instanceof ApiException) {
                                // An error occurred when communicating with the
                                // reCAPTCHA service. Refer to the status code to
                                // handle the error appropriately.
                                ApiException apiException = (ApiException) e;
                                int statusCode = apiException.getStatusCode();

                            } else {
                                // A different, unknown type of error occurred.
                            }
                        }
                    }, BookNowFragment.this );
                }



            }
        });

        return view;
    }





}