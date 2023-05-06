package com.example.projectphase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.app.job.JobScheduler;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
//import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
//Splash Screen///////////////////////////////////////
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent i = new Intent(MainActivity.this,HomePage.class);
        startActivity(i);
        finish();
    }
},2000);


    }





}