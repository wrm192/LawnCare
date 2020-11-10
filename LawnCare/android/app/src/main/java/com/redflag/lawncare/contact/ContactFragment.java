package com.redflag.lawncare.contact;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
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
import com.redflag.lawncare.common.api.ContactNowApiService;
import com.redflag.lawncare.common.api.dto.ContactNowRequest;
import com.redflag.lawncare.common.api.dto.UpdateFragment;
import com.redflag.lawncare.common.email.EmailBuilder;
import com.redflag.lawncare.common.recaptcha.VerificationService;

public class ContactFragment extends Fragment implements UpdateFragment {

    private boolean preferEmail = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);


        TextInputLayout nameInput = rootView.findViewById(R.id.con_name);
        TextInputLayout phoneNumbInput = rootView.findViewById(R.id.con_phoneNum);
        TextInputLayout emailInput = rootView.findViewById(R.id.con_email);

        EditText inquiryInput = rootView.findViewById(R.id.inquiryInput);

        setupRadioButton(rootView);

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

                    new VerificationService(response -> {
                        // Indicates communication with reCAPTCHA service was
                        // successful.
                        String userResponseToken = response.getTokenResult();
                        ContactNowRequest request = new ContactNowRequest();
                        request.setName(name.getText().toString());
                        request.setComment(inquiryInput.getText().toString());
                        request.setContactDetails((preferEmail) ? email.getText().toString(): phoneNumb.getText().toString());
                        ContactNowApiService contactNowApiService = new ContactNowApiService(ContactFragment.this, request);
                        contactNowApiService.execute();
                        Toast.makeText(getContext(), getResources().getString(R.string.attempting_to_contact), Toast.LENGTH_LONG).show();
                        name.setText("");
                        phoneNumb.setText("");
                        email.setText("");
                        inquiryInput.setText("");

                    }, e -> {
                        if (e instanceof ApiException) {
                            // An error occurred when communicating with the
                            // reCAPTCHA service. Refer to the status code to
                            // handle the error appropriately.
                            ApiException apiException = (ApiException) e;
                            int statusCode = apiException.getStatusCode();

                        } else {
                            // A different, unknown type of error occurred.
                        }
                    }, ContactFragment.this );

                }


            }
        });

        return rootView;


    }

    public void setupRadioButton(View view) {
        // Is the button now checked?
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.pref_group);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch(checkedId) {
                case R.id.pref_email:
                    preferEmail = true;
                    break;
                case R.id.pref_phone:
                    preferEmail = false;
                    break;
            }
        });

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

    @Override
    public void updateFragment() {
        getActivity().runOnUiThread(() -> Toast.makeText(getContext(), getResources().getString(R.string.sent_contact), Toast.LENGTH_LONG).show());
    }
}
