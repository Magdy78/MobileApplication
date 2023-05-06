package com.example.projectphase1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;



import java.security.Provider;

public class Myservice extends Service {
    public Myservice(){

    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet");
    }
}
