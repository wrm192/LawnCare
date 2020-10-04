package com.redflag.lawncare.calculation;

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

public class CalculationFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booknow,
                container, false);


        Button submit = view.findViewById(R.id.SubmitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout input1_TIL = view.findViewById(R.id.input_1);
                TextInputLayout input2_TIL = view.findViewById(R.id.input_2);

                EditText input1 = input1_TIL.getEditText();
                EditText input2 = input2_TIL.getEditText();

                boolean error;
                error = checkForError(input1, false);
                error = checkForError(input2, error);

                if (!error) {

                    clearError(input1);
                    clearError(input2);
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
}
