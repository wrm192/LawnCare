package com.redflag.lawncare.book;

import android.os.Bundle;
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
import com.redflag.lawncare.common.email.EmailBuilder;
import com.redflag.lawncare.common.recaptcha.VerificationService;

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
                TextInputLayout addressTIL = view.findViewById(R.id.address);
                TextInputLayout phoneNumberTIL = view.findViewById(R.id.phoneNum);
                TextInputLayout nameTIL = view.findViewById(R.id.name);

                EditText address = addressTIL.getEditText();
                EditText name = nameTIL.getEditText();
                EditText phoneNumber = phoneNumberTIL.getEditText();

                boolean error;
                error = checkForError(address, false);
                error = checkForError(name, error);
                error = checkForError(phoneNumber, error);
                error = validatePhoneNumber(phoneNumber, error);

                if(!error){

                    clearError(address);
                    clearError(name);
                    clearError(phoneNumber);

                    new VerificationService(new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                        @Override
                        public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                            // Indicates communication with reCAPTCHA service was
                            // successful.
                            EmailBuilder.buildEmail("Consultation - " + name.getText().toString(),
                                    name.getText().toString() + " is looking for a consultation \ndetails:\nPhone number: "
                                            + phoneNumber.getText().toString() + "\nAddress: " + address.getText().toString());

                            Toast.makeText(getContext(), getResources().getString(R.string.sent_consultation), Toast.LENGTH_LONG).show();
                            address.setText("");
                            name.setText("");
                            phoneNumber.setText("");
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


}
