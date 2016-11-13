package demo.cehua.nicestars.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.finalteam.okhttpfinal.RequestParams;
import utils.Global;
import utils.HttpUtil;
import view.CostomButtom;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public class ZipCodeActivity extends BaseActivity implements View.OnClickListener {

    private TextView titlename;
    private EditText cityname_ed;
    private Button search_btn;
    private CostomButtom cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.zipcode_activity);
        initView();
    }

    @Override
    protected void initView() {
        titlename = (TextView) findViewById(R.id.title_name);
        titlename.setText("邮编查询");
        cityname_ed = (EditText) findViewById(R.id.cityname_ed);
        search_btn = (Button) findViewById(R.id.search_btn);
        cc = (CostomButtom) findViewById(R.id.dd);
      //  cc.setcostomtext("无知者在劫难逃");
       /* cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ZipCodeActivity.this, "11", Toast.LENGTH_SHORT).show();
            }
        });
*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.search_btn:

                break;

            default:
                break;

        }
    }

    public void getRequest(String cityname) {
        RequestParams params = new RequestParams();//请求参数
        params.addFormDataPart("cityname", cityname);//城市名称
        params.addFormDataPart("appkey", "");
        HttpUtil.post(Global.juheurlforzipcode, params, this);

    }
}
