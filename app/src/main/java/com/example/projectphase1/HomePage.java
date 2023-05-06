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

public class HomePage extends AppCompatActivity {
    private Button button, NotifyButton;
    private View parentView;
    public SwitchMaterial themeSwitch;
    private TextView theme, title;
    private UserSettings settings;
    public JobScheduler scheduler;
    private static final int JOB_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();
//Splash Screen///////////////////////////////////////






// intent to transfer to next page
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openMainPage();
            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Shared Preferences to make the layout Toggle dark mode
        {
            settings = (UserSettings) getApplication();
            initWidgets();
            loadSharedPrefrs();
            initSwitchListner();
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        //Broadcast Reciver
        BroadCastReciver BroadCastReciver = new BroadCastReciver();
        //Broadcast Reciver
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        // the types of broadcast intents that the receiver should receive.
        registerReceiver(BroadCastReciver, intentFilter);
        ///////////////////////////////////////////////////////////////////////////////}

        //Job Scheduler

        scheduler=(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        NotifyButton=findViewById(R.id.button4);

        NotifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Notifications
                ComponentName serviceName = new ComponentName(getPackageName(), NotificationJobService.class.getName());
                JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, serviceName);
                builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
                JobInfo myjob=builder.build();
                scheduler.schedule(myjob);

            }
        });


    }




















    private void initWidgets() {
// widgets that are changing so we get there id
        themeSwitch = findViewById(R.id.ThemeSwitch);
        parentView = findViewById(R.id.parentView);
        theme = findViewById(R.id.Text2);
        title = findViewById(R.id.Text3);
        // text1 = findViewById(R.id.)

    }

    private void loadSharedPrefrs() {
        //shared preferences to save the state of the theme
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE);
        String theme = sharedPreferences.getString(UserSettings.Custom_Theme, UserSettings.Light_Theme);
        settings.setCustomTheme(theme);
        UpdateView();
    }


    // code for the Switch Part if Conditon to Check if the switch is On of off
    private void initSwitchListner() {

        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    settings.setCustomTheme(UserSettings.Dark_Theme);
                else
                    settings.setCustomTheme(UserSettings.Light_Theme);

                SharedPreferences.Editor editor = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE).edit();
                editor.putString(UserSettings.Custom_Theme, settings.getCustomTheme());
                editor.apply();
                UpdateView();


            }


        });

    }

    private void UpdateView() {
        final int black = ContextCompat.getColor(this, R.color.black);
        final int white = ContextCompat.getColor(this, R.color.white);
        if (settings.getCustomTheme().equals(UserSettings.Dark_Theme)) {
            parentView.setBackgroundColor(black);
            themeSwitch.setChecked(true);
            theme.setTextColor(white);
            title.setTextColor(white);
            themeSwitch.setText("Light Mode");
        } else {
            parentView.setBackgroundColor(white);
            themeSwitch.setChecked(false);
            theme.setTextColor(black);
            title.setTextColor(black);
        }


    }


    public void openMainPage() {
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

}