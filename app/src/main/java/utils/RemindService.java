package utils;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Calendar;

import demo.cehua.nicestars.activity.MainActivity;
import demo.cehua.nicestars.activity.R;

/**
 * Created by Administrator on 2016/10/29 0029.
 */
public class RemindService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Intent intent = new Intent(RemindService.this, Receiver.class);
        intent.setAction("RemindAction");
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        PendingIntent sender = PendingIntent.getBroadcast(
                RemindService.this, 0, intent, 0);

        // We want the alarm to go off 5 seconds from now.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND,5);

        // Schedule the alarm!
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);


    }
}
