package com.example.projectphase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

Button Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        getSupportActionBar().hide();


        //// Video Layout for the Page
    VideoView videoview = findViewById(R.id.videoView);
    String VideoPath = "android.resource://"+getPackageName()+"/"+R.raw.fifagoal;
    Uri uri = Uri.parse(VideoPath);
    videoview.setVideoURI(uri);
    videoview.start();

    MediaController mediaController = new MediaController(this);
    videoview.setMediaController(mediaController);
    mediaController.setAnchorView(videoview);
        ////================================> end of the ?Layout of Video Viewer

    //button To transfer to Next Page RecycleView

        Button = (Button) findViewById(R.id.button2);
        Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openRecyclePage();
            }
        });

    }

    public void openRecyclePage() {
        Intent intent = new Intent(this, RecycleView.class);
        startActivity(intent);
    }





}