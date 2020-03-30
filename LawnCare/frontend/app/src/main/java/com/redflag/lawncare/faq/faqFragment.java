package com.redflag.lawncare.faq;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.redflag.lawncare.R;


public class faqFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faq,
                container, false);

        String[] faqItems = {"Q1", "Q2", "Q3", "Q4"};
        ListView listView = (ListView) view.findViewById(R.id.listView);

        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, faqItems);

        listView.setAdapter(ListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getActivity(), "A1-----------", Toast.LENGTH_LONG).show();
                } else if (position == 1) {
                    Toast.makeText(getActivity(), "A2 hhhhhhhhhhhhhhhhi", Toast.LENGTH_LONG).show();
                } else if (position == 2) {
                    Toast.makeText(getActivity(), "A3 morningggggggggggggggg", Toast.LENGTH_LONG).show();
                }else if (position == 3) {
                    Toast.makeText(getActivity(), "A4 anserssssss", Toast.LENGTH_LONG).show();
                }
                }
        });

        return view;
    }
}

