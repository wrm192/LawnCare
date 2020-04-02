package com.redflag.lawncare.contact;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.redflag.lawncare.R;
import com.redflag.lawncare.common.email.EmailService;
import com.redflag.lawncare.common.recaptcha.VerificationActivity;

public class ContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);


        TextInputLayout nameInput = rootView.findViewById(R.id.name);
        TextInputLayout phoneNumbInput = rootView.findViewById(R.id.phoneNum);
        TextInputLayout emailInput = rootView.findViewById(R.id.email);

        EditText inquiryInput = rootView.findViewById(R.id.inquiryInput);

        Button submit = rootView.findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = nameInput.getEditText();
                EditText phoneNumb = phoneNumbInput.getEditText();
                EditText email = emailInput.getEditText();
                String inquiry = inquiryInput.getText().toString();

                boolean error = false;
                boolean errorInquiry = false;
                error = checkForError(name, error);
                error = checkForError(phoneNumb, error);
                error = validatePhoneNumber(phoneNumb, error);
                error = checkForError(email,error);
                error = validateEmail(email, error);

                errorInquiry = checkForInquiry(inquiry, error);


                if (errorInquiry) {
                    inquiryInput.setError(getString(R.string.err_cant_be_empty));
                    error = true;
                }

                if (!error) {

                    clearError(name);
                    clearError(phoneNumb);
                    clearError(email);

                    new VerificationActivity(new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                        @Override
                        public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                            // Indicates communication with reCAPTCHA service was
                            // successful.
                            String userResponseToken = response.getTokenResult();
                            new EmailService("Contact Us - " + name.getText().toString(), "Name: " + name.getText().toString() + "\nPhone: " + phoneNumb.getText().toString() + "\nEmail: " + email.getText().toString() + "\n\nInquiry:\n" + inquiry);
                            Toast.makeText(getContext(), getResources().getString(R.string.sent_contact), Toast.LENGTH_SHORT).show();
                            name.setText("");
                            phoneNumb.setText("");
                            email.setText("");
                            inquiryInput.setText("");

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
                    }, ContactFragment.this );

                }


            }
        });

        return rootView;


    }

    private boolean checkForInquiry(String text, boolean errorState) {
        if("".equals(text)){
            return true;
        }
        return errorState;
    }

    private boolean checkForError(EditText text, boolean errorState) {
        if("".equals(text.getText().toString())){
            text.setError(getString(R.string.err_cant_be_empty));
            return true;
        }
        return errorState;
    }
    private void clearError (EditText text) {
        text.setError(null);
    }

    private boolean validatePhoneNumber(EditText phone, boolean errorState) {
        if(!android.util.Patterns.PHONE.matcher(phone.getText().toString()).matches()){
            phone.setError(getString(R.string.err_must_be_phone));
            return true;
        }
        return errorState;
    }

    private boolean validateEmail(EditText email, boolean errorState) {
        if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
            email.setError(getString(R.string.err_must_be_email));
            return true;
        }
        return errorState;
    }
}
