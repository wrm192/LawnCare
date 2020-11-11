package com.redflag.lawncare.calculation;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.content.ClipboardManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.redflag.lawncare.R;
import com.redflag.lawncare.common.api.ApiCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.Context.CLIPBOARD_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class CalculationFragment extends Fragment {
    private RadioGroup rg1,rg2;
    private RadioButton rb_1, rb_2,rb_4, rb_5,rb_6, rb_7;
    private View view;
    private double tree =6.2;
    private EditText et_1;
    String strBtnSelected ="";
    private FloatingActionButton item_btn_add;
    private HorizontalListViewAdapter hListViewAdapter;
    private MyDetailsListView listview;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calculation,
                container, false);


        TextInputLayout areaInput = view.findViewById(R.id.area);
        TextInputLayout obstructionInput = view.findViewById(R.id.obstruction);
        item_btn_add = view.findViewById(R.id.floatingActionButton4);
        listview = (MyDetailsListView) view.findViewById(R.id.listview);
        List<Obstruction> obstruction=new ArrayList<Obstruction>();
        hListViewAdapter = new HorizontalListViewAdapter(getActivity(), obstruction);
        listview.setAdapter(hListViewAdapter);
        item_btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hListViewAdapter.newObstruction();
                //listview.setAdapter(hListViewAdapter);
            }
        });
        initView();

        Button submit1 = view.findViewById(R.id.SubmitButton1);
        Button submit2 = view.findViewById(R.id.submitButton2);
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_1.setEnabled(true);
                rb_1.setChecked(true);

                rb_2.setChecked(false);
                rb_4.setChecked(false);
                rb_5.setChecked(false);
                rb_6.setChecked(false);
                rb_7.setChecked(false);
                rb_4.setEnabled(false);
                rb_5.setEnabled(false);
                rb_6.setEnabled(false);
                rb_7.setEnabled(false);
                List<Obstruction> obstruction=new ArrayList<Obstruction>();
                hListViewAdapter = new HorizontalListViewAdapter(getActivity(), obstruction);
                listview.setAdapter(hListViewAdapter);

            }
        });
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double numb = 0;
                final double[] spinnerItems = {120,350,220,580};
                if (rb_1.isChecked()){
                    try {
                        numb = Double.parseDouble(et_1.getText().toString());

                    }catch (Exception e){
                        numb=0.0;
                    }

                }else if(rb_4.isChecked()){
                    numb=spinnerItems[0];

                }else if(rb_5.isChecked()){
                    numb=spinnerItems[1];

                }else if(rb_6.isChecked()){
                    numb=spinnerItems[2];

                }else if(rb_7.isChecked()){
                    numb=spinnerItems[3];

                }
                System.out.println(obstruction.size());
                double lawn_numb=0;
                for (int i =0;i<obstruction.size();i++){
                    System.out.println(obstruction.get(i).getPersonName()+","+obstruction.get(i).getPersonAddress()+","+obstruction.get(i).getPersonNumb());
                    if (obstruction.get(i).getPersonName().equals("tree")){
                        lawn_numb+=tree*obstruction.get(i).getPersonNumb();

                    }else{
                        lawn_numb+=obstruction.get(i).getPersonNumb();
                    }
                }
                String lawn1= String.format("Lawn Area: %s Sq ft", numb);
                String lawn2= String.format("Obstruction Size: %s Sq ft", lawn_numb);
                String lawn3=String.format("Actual Size: %s Sq ft", numb-lawn_numb);
                BigDecimal num1 = new BigDecimal((numb-lawn_numb)*15);
                String lawn4=String.format("Estimated Price:$%s", num1);
                List<String> lawn = new ArrayList<String>();
                lawn.add(lawn1);
                lawn.add(lawn2);
                lawn.add(lawn3);
                lawn.add(lawn4);



                showDialog(Objects.requireNonNull(getActivity()),lawn);


            }
        });
        return view;
    }
    private void initView() {
        rg1 = (RadioGroup) view.findViewById(R.id.radio1);
        rg2 = (RadioGroup) view.findViewById(R.id.radio2);

        rb_1 = (RadioButton) view.findViewById(R.id.radioButton2);
        rb_2 = (RadioButton) view.findViewById(R.id.radioButton3);
        rb_4 = (RadioButton) view.findViewById(R.id.radioButton4);
        rb_5 = (RadioButton) view.findViewById(R.id.radioButton5);
        rb_6 = (RadioButton) view.findViewById(R.id.radioButton6);
        rb_7 = (RadioButton) view.findViewById(R.id.radioButton7);
        et_1 = (EditText) view.findViewById(R.id.editText);

        BtnSelected btnSelected1 = new BtnSelected("1");
        BtnSelected btnSelected2 = new BtnSelected("2");
        BtnSelected btnSelected4 = new BtnSelected("4");
        BtnSelected btnSelected5 = new BtnSelected("5");
        BtnSelected btnSelected6 = new BtnSelected("6");
        BtnSelected btnSelected7 = new BtnSelected("7");

        rb_1.setOnClickListener(btnSelected1);
        rb_2.setOnClickListener(btnSelected2);

        rb_4.setOnClickListener(btnSelected4);
        rb_5.setOnClickListener(btnSelected5);
        rb_6.setOnClickListener(btnSelected6);
        rb_7.setOnClickListener(btnSelected7);

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

        System.out.println("in fragment" + "");
    }

    public void newCalc(double area, double obstruction) {
        ApiCalculator apiCalculator = new ApiCalculator(this, area, obstruction);
        apiCalculator.execute();
    }
    public class BtnSelected implements View.OnClickListener {

        private String btnId;

        public BtnSelected(String str) {
            btnId = str;
        }
        @Override
        public void onClick(View v) {
            strBtnSelected = btnId;//选择的某一项
            //点击了第一行　，就把另外行的点击项清空
            if (btnId.equals("1") ) {
                et_1.setEnabled(true);

                rb_2.setChecked(false);
                rb_4.setChecked(false);
                rb_5.setChecked(false);
                rb_6.setChecked(false);
                rb_7.setChecked(false);
                rb_4.setEnabled(false);
                rb_5.setEnabled(false);
                rb_6.setEnabled(false);
                rb_7.setEnabled(false);

            } else if (btnId.equals("2") ) {
                et_1.setEnabled(false);
                rb_1.setChecked(false);
                rb_2.setChecked(true);
                rb_4.setChecked(true);
                rb_5.setChecked(false);
                rb_6.setChecked(false);
                rb_7.setChecked(false);

                rb_4.setEnabled(true);
                rb_5.setEnabled(true);
                rb_6.setEnabled(true);
                rb_7.setEnabled(true);
            }else if (btnId.equals("4")){
                rb_1.setChecked(false);
                rb_2.setChecked(true);
                rb_4.setChecked(true);
                rb_5.setChecked(false);
                rb_6.setChecked(false);
                rb_7.setChecked(false);
            } else if (btnId.equals("5")){
                rb_1.setChecked(false);
                rb_2.setChecked(true);

                rb_4.setChecked(false);
                rb_5.setChecked(true);
                rb_6.setChecked(false);
                rb_7.setChecked(false);
            }else if (btnId.equals("6")){
                rb_1.setChecked(false);
                rb_2.setChecked(true);

                rb_4.setChecked(false);
                rb_5.setChecked(false);
                rb_6.setChecked(true);
                rb_7.setChecked(false);
            }else if (btnId.equals("7")){
                rb_1.setChecked(false);
                rb_2.setChecked(true);

                rb_4.setChecked(false);
                rb_5.setChecked(false);
                rb_6.setChecked(false);
                rb_7.setChecked(true);
            }
        }
    }
    private void showDialog(Context context,List<String> strs){
        LayoutInflater mInflater;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);

        assert mInflater != null;
        View view = mInflater.inflate(R.layout.dialog_normal_layout, null);
        final AlertDialog dialog = new AlertDialog.Builder(context).setView(view).create();

        FloatingActionButton floatingActionButton2 = view.findViewById(R.id.floatingActionButton2);
        Button button = view.findViewById(R.id.button);

        TextView textView5 =view.findViewById(R.id.textView5);
        TextView textView6 =view.findViewById(R.id.textView6);
        TextView textView7 =view.findViewById(R.id.textView7);
        TextView textView8 =view.findViewById(R.id.textView8);
        textView5.setText(strs.get(0));
        textView6.setText(strs.get(1));
        textView7.setText(strs.get(2));
        textView8.setText(strs.get(3));
        String data =strs.get(0)+"\n"+strs.get(1)+"\n"+strs.get(2)+"\n"+strs.get(3)+"\n";
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //... To-do
                dialog.dismiss();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard;
                clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

                // 创建一个剪贴数据集，包含一个普通文本数据条目（需要复制的数据）,其他的还有
                // newHtmlText、
                // newIntent、
                // newUri、
                // newRawUri
                ClipData clipData = ClipData.newPlainText(null, data);

                // 把数据集设置（复制）到剪贴板
                assert clipboard != null;
                clipboard.setPrimaryClip(clipData);
                //... To-do
                dialog.dismiss();
            }


        });

        dialog.show();
        Objects.requireNonNull(dialog.getWindow()).setLayout((ScreenUtils.getScreenWidth(context)), LinearLayout.LayoutParams.WRAP_CONTENT);
    }

}
class ScreenUtils {


    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

}
