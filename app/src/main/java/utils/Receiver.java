package utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import demo.cehua.nicestars.activity.MainActivity;
import demo.cehua.nicestars.activity.R;

/**
 * Created by Administrator on 2016/10/29 0029.
 */
public class Receiver extends BroadcastReceiver {

    private String str;
    private static final int NOTIFICATION_FLAG = 1;
    private Context ctx;
    @Override
    public void onReceive(Context ctx, Intent intent) {
        Log.e("11111111ss", "1");
        String action = intent.getAction();
        if (action.equals("RemindAction")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss  ");
            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
            str = formatter.format(curDate);
           // ShowNotification();
            Log.e("11111111ss", "当前时间是" + str);
            Toast.makeText(ctx, "当前时间是" + str, Toast.LENGTH_SHORT).show();
        } else {

        }
    }



    /*public void ShowNotification() {
        // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
        NotificationManager manager = (NotificationManager) ctx.getSystemService(ctx.NOTIFICATION_SERVICE);

        PendingIntent pendingIntent3 = PendingIntent.getActivity(ctx, 0,
                new Intent(ctx, MainActivity.class), 0);
        // 通过Notification.Builder来创建通知，注意API Level
        // API16之后才支持
        Notification notify3 = new Notification.Builder(ctx)
                .setSmallIcon(R.mipmap.launcher)
                .setTicker("TickerText:" + "您有新短消息，请注意查收！")
                .setContentTitle("时间推送")
                .setContentText("现在时间是：" + str)
                .setContentIntent(pendingIntent3).setNumber(1).build(); // 需要注意build()是在API
        // level16及之后增加的，API11可以使用getNotificatin()来替代
        notify3.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
        manager.notify(NOTIFICATION_FLAG, notify3);// 步骤4：通过通知管理器来发起通知。如果id不同，则每click，在status哪里增加一个提示
    }*/
}

