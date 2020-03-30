package com.redflag.lawncare.faq;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.redflag.lawncare.R;

import java.util.ArrayList;


public class FaqFragment extends Fragment {

    //String[] faqItems = {"Q1", "Q2", "Q3", "Q4"};
    // String[] faqAnswers = {"A1", "A2", "A3", "A4"};

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faq,
                container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);

        Faq question1 = new Faq("question1","answer1");
        Faq question2 = new Faq("question2","answer2");
        Faq question3 = new Faq("question3","answer3");
        Faq question4 = new Faq("question4","answer4");

        ArrayList<Faq> faqList = new ArrayList<>();
        faqList.add(question1);
        faqList.add(question2);
        faqList.add(question3);
        faqList.add(question4);

        FaqListAdapter adapter = new FaqListAdapter(getActivity(),R.layout.fragment_cus,faqList);
        listView.setAdapter(adapter);

        //ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, faqItems);

       // listView.setAdapter(ListViewAdapter);

        return view;
    }
}

