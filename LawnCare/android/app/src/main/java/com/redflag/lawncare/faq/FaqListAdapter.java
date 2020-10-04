package com.redflag.lawncare.faq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.redflag.lawncare.R;

import java.util.ArrayList;

public class FaqListAdapter extends ArrayAdapter<Faq> {

    private Context mContext;
    int mResource;
    public FaqListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Faq> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get Q and A
        String question = getItem(position).getQuestion();
        String answer = getItem(position).getAnswer();

        Faq faq = new Faq(question,answer);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvQuestion = (TextView) convertView.findViewById(R.id.question);
        TextView tvAnswer = (TextView) convertView.findViewById(R.id.answer);

        tvQuestion.setText(question);
        tvAnswer.setText(answer);
        return convertView;
    }
}
