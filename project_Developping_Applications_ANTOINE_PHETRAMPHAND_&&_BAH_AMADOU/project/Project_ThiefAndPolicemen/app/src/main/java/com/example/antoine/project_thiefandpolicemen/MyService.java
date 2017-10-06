package com.example.antoine.project_thiefandpolicemen;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Antoine on 28/12/15.
 */
public class MyService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"The game is created",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,GameService.class);
        /*startActivity(intent);*/

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"The game is started",Toast.LENGTH_LONG).show();
        //stopSelf();


        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"The game is stopped",Toast.LENGTH_LONG).show();
        // stopSelf();

    }
}
