package com.redflag.lawncare.faq;

import android.os.Bundle;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import com.redflag.lawncare.R;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Map;



public class Faq extends AppCompatActivity

{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq);

        ListView faqView =(ListView) findViewById(R.id.listview);

        HashMap<String,String> faqList = new HashMap<>();

        faqList.put("Question?","Answer!");
        faqList.put("Are you sure?", "Heck yea brother!");

        List<HashMap<String, String>> listItems = new ArrayList<>();

        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.faq,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});

        Iterator it = faqList.entrySet().iterator();

        while (it.hasNext()){

            HashMap<String,String> results = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            results.put("First Line", pair.getKey().toString());
            results.put("Second Line", pair.getValue().toString());
            listItems.add(results);
        }

        faqView.setAdapter(adapter);

         }
    }