package com.redflag.lawncare.common.recaptcha;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.redflag.lawncare.MainActivity;

public class VerificationService {

    private OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse> listener;
    private OnFailureListener failureListener;
    private AppCompatActivity component;

    public VerificationService(OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse> listener, OnFailureListener failureListener, AppCompatActivity component){
        this.failureListener = failureListener;
        this.listener = listener;
        this.component = component;
        this.checkCaptchaBox();
    }

    public VerificationService(OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse> listener, OnFailureListener failureListener, Fragment fragment){
        this(listener, failureListener, (MainActivity)fragment.getActivity());
    }

    private void checkCaptchaBox() {

        SafetyNet.getClient(component).verifyWithRecaptcha("6Lf5nOQUAAAAAIiUBfbb_2Tb5_fm7905Bts5zIYn")
                .addOnSuccessListener(component, this.listener)
                .addOnFailureListener(component, this.failureListener);

    }

}
