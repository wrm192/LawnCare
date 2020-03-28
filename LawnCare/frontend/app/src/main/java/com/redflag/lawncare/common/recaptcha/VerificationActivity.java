package com.redflag.lawncare.common.recaptcha;

/*
public class VerificationActivity extends MainActivity {

    private CheckBox checkBox;
    private TextView testView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    private void CheckCaptchaBox(boolean isChecked) {
        if (isChecked) {
            SafetyNet.getClient(this).verifyWithRecaptcha("6Lf5nOQUAAAAAIiUBfbb_2Tb5_fm7905Bts5zIYn")
                    .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                        @Override
                        public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                            // Indicates communication with reCAPTCHA service was
                            // successful.
                            String userResponseToken = response.getTokenResult();
                            if (!userResponseToken.isEmpty()) {
                                // Validate the user response token using the
                                // reCAPTCHA siteverify API.
                                handleSiteVerify(response.getTokenResult());
                            }
                        }
                    })
                    .addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if (e instanceof ApiException) {
                                // An error occurred when communicating with the
                                // reCAPTCHA service. Refer to the status code to
                                // handle the error appropriately.
                                ApiException apiException = (ApiException) e;
                                int statusCode = apiException.getStatusCode();
                                Log.d(TAG, "Error: " + CommonStatusCodes
                                        .getStatusCodeString(statusCode));
                            } else {
                                // A different, unknown type of error occurred.
                                Log.d(TAG, "Error: " + e.getMessage());
                            }
                        }
                    });
        }
    }

    //Server side code for captcha
    private void handleSiteVerify(String tokenResult) {

        textView1.setText(tokenResult);


    }

    private class MyNetworkCode extends AsyncTask<String,Void,Void> {

        ProgressDialog progressDialog;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        InputStream inputStream;
        OutputStream outputStream;
        InputStreamReader inputStreamReader;
        OutputStreamWriter outputStreamWriter;

        HttpsURLConnection httpsURLConnection;
        URL url;

        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }

    }



}
*/