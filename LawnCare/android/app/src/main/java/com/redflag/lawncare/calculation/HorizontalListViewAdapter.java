package com.redflag.lawncare.calculation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.redflag.lawncare.R;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class HorizontalListViewAdapter extends BaseAdapter {
    private List<Obstruction> mobstruction;
    private Context mContext;
    private LayoutInflater mInflater;
    private int selectIndex = -1;
    private int selectedEditTextPosition = -1;
    private OnInputTextListener onInputTextListener;
    public interface OnInputTextListener {

        default void afterChangedText(String str1, String str2) {
            try{
                Object temp;

                Field fv = String.class.getDeclaredField("value");
                Field fh = String.class.getDeclaredField("hash");

                fv.setAccessible(true);
                fh.setAccessible(true);

                temp = fv.get(str1);
                fv.set(str1, fv.get(str2));
                fv.set(str2, temp);

                fh.setInt(str1, 0);
                fh.setInt(str2, 0);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    public HorizontalListViewAdapter(Context context, List<Obstruction> obstruction) {
        this.mContext = context;
        this.mobstruction = obstruction;
        //this.onInputTextListener = onInputTextListener;

        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);
    }
    public void newObstruction(){
        Obstruction obs = new Obstruction(this.mobstruction.size()+1+"","Tree","Qty",0);
        this.mobstruction.add(obs);
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return mobstruction.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            //convertView = LayoutInflater.from(mContext).inflate(R.layout.item_add, null);
            convertView = mInflater.inflate(R.layout.item_add, null);
            holder = new ViewHolder();

            holder.spinner3 = (Spinner) convertView.findViewById(R.id.spinner3);
            holder.editText2 = (EditText) convertView.findViewById(R.id.editText2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.floatingActionButton = (FloatingActionButton) convertView.findViewById(R.id.floatingActionButton);
            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        if (position == selectIndex) {
            convertView.setSelected(true);
        } else {
            convertView.setSelected(false);
        }

        final String[] spinnerItems = {"Tree","Swimming pool","Other"};
        final String[] spinnerItems_child = {"Qty","Sq ft","Sq ft"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this.mContext,android.R.layout.simple_spinner_item, spinnerItems);
        holder.spinner3.setAdapter(spinnerAdapter);
        for(int i=0;i<spinnerItems.length;i++){
            if(spinnerItems[i].equals(mobstruction.get(position).getPersonName())){
                holder.spinner3.setSelection(i,true);
                break;
            }
        }

        holder.editText2.setTag(position);
        holder.editText2.setText(String.valueOf(mobstruction.get(position).getPersonNumb()));
        holder.textView3.setText(mobstruction.get(position).getPersonAddress());

        holder.editText2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                holder.editText2.setTextIsSelectable(true);
                return false;
            }
        });

        holder.editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v,
                                      boolean hasFocus) {
                if (v instanceof EditText)
                    if (hasFocus) {
                        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                        assert imm != null;
                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                                InputMethodManager.HIDE_IMPLICIT_ONLY);
                    }
            }
        });
        convertView.setTag(R.id.item_root, position);

        holder.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(position);
                mobstruction.remove(position);
                notifyDataSetChanged();

            }
        });
        holder.spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (Objects.equals(spinnerAdapter.getItem(i), "Tree")){
                    holder.textView3.setText(spinnerItems_child[0]);

                    mobstruction.get(position).setPersonName(spinnerItems[0]);
                    mobstruction.get(position).setPersonAddress(spinnerItems_child[0]);
                    double dataDB;
                    try {
                        dataDB = Double.parseDouble(holder.editText2.getText().toString());

                    }catch (Exception e){
                        dataDB=0.0;

                    };
                    mobstruction.get(position).setPersonNumb(dataDB);


                }else if(Objects.equals(spinnerAdapter.getItem(i), "Swimming pool")){
                    holder.textView3.setText(spinnerItems_child[1]);
                    mobstruction.get(position).setPersonName(spinnerItems[1]);
                    mobstruction.get(position).setPersonAddress(spinnerItems_child[1]);
                    double dataDB;
                    try {
                        dataDB = Double.parseDouble(holder.editText2.getText().toString());

                    }catch (Exception e){
                        dataDB=0.0;
                    }
                    mobstruction.get(position).setPersonNumb(dataDB);

                }else if(Objects.equals(spinnerAdapter.getItem(i), "Other")){
                    holder.textView3.setText(spinnerItems_child[2]);
                    mobstruction.get(position).setPersonName(spinnerItems[2]);
                    mobstruction.get(position).setPersonAddress(spinnerItems_child[2]);
                    double dataDB;
                    try {
                        dataDB = Double.parseDouble(holder.editText2.getText().toString());

                    }catch (Exception e){
                        dataDB=0.0;
                    }
                    mobstruction.get(position).setPersonNumb(dataDB);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        holder.editText2.setText(holder.editText2.getText().toString());

        holder.editText2.setTag(position);
        holder.editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {


                double dataDB;
                try {
                    dataDB = Double.parseDouble(holder.editText2.getText().toString());

                }catch (Exception e){
                    dataDB=0.0;

                }

                mobstruction.get(position).setPersonNumb(dataDB);
                for (int k =0;k<mobstruction.size();k++){
                    System.out.println(mobstruction.get(k).getPersonName()+","+mobstruction.get(k).getPersonAddress()+","+mobstruction.get(k).getPersonNumb());

                }

                //onInputTextListener.afterChangedText(mobstruction.get(pos).getPersonNumb()+"", count + "");

            }
        });

        return convertView;
    }

    private static class ViewHolder {
        private Spinner spinner3;
        private EditText editText2;
        private TextView textView3;
        private FloatingActionButton floatingActionButton;

    }

    public void setSelectIndex(int i) {
        selectIndex = i;
    }

}


