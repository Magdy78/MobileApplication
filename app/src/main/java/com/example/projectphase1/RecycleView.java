package com.example.projectphase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecycleView extends AppCompatActivity {
RecyclerView recyclerView;
RecycleAdapter recycleAdapter;
String Title[]={"Germany Conquer the World","Aguero Saves the City","Egyptian Miracle"
,"New Pele","La Decima","Baggio Died Standing","Messi World Hero","Ronaldo wins everything","Egyptian king","Ryiad Mahrez Gets The Gold"
        ,"Benzima and the 14th Star"};

String EventName[]={"FIFA WORLD CUP 2014","Premier League 2012","AFCON 2006-2010"
            ,"FIFA WORLD CUP 2018","UEFA Champions League 2014","FIFA WORLD CUP 1994","FIFA WORLD CUP 2022","UEFA Euro 2016",
"Premier League 2017","Premier League 2015","UEFA Champions League 2022"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view2);
        getSupportActionBar().hide();


        recyclerView = findViewById(R.id.RecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleAdapter = new RecycleAdapter(this,Title,EventName);
        recyclerView.setAdapter(recycleAdapter);
    }
}
