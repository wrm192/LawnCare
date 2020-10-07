package com.redflag.lawncare.calculation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.redflag.lawncare.R;
import com.redflag.lawncare.common.api.ApiCalculator;

import java.io.IOException;

public class CalculationFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculation,
                container, false);


        Button submit = view.findViewById(R.id.SubmitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout area_TIL = view.findViewById(R.id.area);
                TextInputLayout obstruction_TIL = view.findViewById(R.id.obstruction);

                double area = Double.parseDouble(area_TIL.getEditText().getText().toString());
                double obstruction = Double.parseDouble(obstruction_TIL.getEditText().getText().toString());

                /*error = checkForError(area, false);
                error = checkForError(obstruction, error);*/

                /*if (!error) {

                    clearError(area);
                    clearError(obstruction);
                }*/

               newCalc(area,obstruction);

            }
        });

        return view;
    }

    private boolean checkForError(EditText text, boolean errorState) {
        if ("".equals(text.getText().toString())) {
            text.setError(getString(R.string.err_cant_be_empty));
            return true;
        }
        return errorState;
    }

    private void clearError(EditText text) {
        text.setError(null);
    }

    public void updateLabel(String val) {
        TextView tx = getView().findViewById(R.id.calculation);
        tx.setText(val);
        System.out.println("in fragment" + val);
    }

    public void newCalc(double area, double obstruction) {
        ApiCalculator apiCalculator = new ApiCalculator(this, area, obstruction);
        apiCalculator.execute();
    }

}
