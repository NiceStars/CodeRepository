package demo.cehua.nicestars.activity;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import adapter.ResultAdapter;
import cn.finalteam.okhttpfinal.RequestParams;
import model.Datasss;
import model.JHRepo;
import utils.Global;
import utils.HttpUtil;
import utils.Receiver;
import utils.RemindService;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private List<Datasss> infos = new ArrayList<>();

    private EditText cityname_ed;
    private Button search_btn;
    private ListView weather_lv;
    private ResultAdapter adapter;
    private static final int NOTIFICATION_FLAG = 1;
    private static final int REQUEST_CODE = 1;
    private TextView titlename;

    private String str;
    private static final int INTERVAL = 1000 * 60 * 60 * 24;// 24h

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    @Override
    protected void initView() {
        cityname_ed = (EditText) findViewById(R.id.cityname_ed);
        search_btn = (Button) findViewById(R.id.search_btn);
        weather_lv = (ListView) findViewById(R.id.weather_lv);
        adapter = new ResultAdapter(this);
        search_btn.setOnClickListener(this);
        titlename = (TextView) findViewById(R.id.title_name);
        titlename.setText("天气预报--—|———|-————");

        //启动服务
       // Intent intent = new Intent(MainActivity.this, RemindService.class);
       // startService(intent);

       /* Intent intent = new Intent(MainActivity.this, Receiver.class);
        intent.setAction("RemindAction");
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        PendingIntent sender = PendingIntent.getBroadcast(
                MainActivity.this, 0, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 10 );

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);*/
    }


    public void getRequest(String cityname) {
        RequestParams params = new RequestParams();//请求参数
        params.addFormDataPart("cityname", cityname);//城市名称
        HttpUtil.post(Global.url, params, this);
        //--____

    }

    @Override
    public void onSuccesOperation(String url, JHRepo apiResponse) {
        super.onSuccesOperation(url, apiResponse);
        if (apiResponse.code.equals("10000")) {
            infos = apiResponse.result.info.forecast;
            for (int i = 0; i < infos.size(); i++) {
                adapter.setInfos(infos);

            }
            weather_lv.setAdapter(adapter);
        }

    }

    @Override
    public void onFailureOperation(String url, String msg, int code) {
        super.onFailureOperation(url, msg, code);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.search_btn:
                String cityname = cityname_ed.getText().toString();
                getRequest(cityname);
                break;
        }
    }




}
