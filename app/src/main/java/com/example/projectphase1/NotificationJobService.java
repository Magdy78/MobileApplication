package com.example.projectphase1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;

import com.example.projectphase1.MainActivity;

public class NotificationJobService extends JobService {

    //Variables
    NotificationManager notificationManager;
    private  static final String primary_channel_ID="primary_notification_chanel";


    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        // Create the notification channel.
        createNotificationChannel();

        //Set up the notification content intent to launch the app when clicked.

        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationJobService.this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, primary_channel_ID);
        builder.setContentTitle("Football Journey");
        builder.setContentText("You will get Notifications through your journey");
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.baseline_sports_handball_24 );
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setAutoCancel(true);

        notificationManager.notify(0, builder.build());

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true ;


    }
    public void createNotificationChannel() {

        // Define notification manager object.
        notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on the SDK version.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (primary_channel_ID,"Job Service notification", NotificationManager.IMPORTANCE_HIGH);


            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription ("Notifications from Job Service");
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
