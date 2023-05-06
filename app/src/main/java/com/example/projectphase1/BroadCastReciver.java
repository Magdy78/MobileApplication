package com.example.projectphase1;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

public class BroadCastReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //check when is the

        if (!(Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) == 0)) {
            // Airplane mode is off, start the home activity
            Intent airplane = new Intent(context, CheckNet.class);
            airplane.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(airplane);
        }
        else{
            Intent homeIntent = new Intent(context,MainActivity.class);
            context.startActivity(homeIntent);
        }

    }
}

