package demo.cehua.nicestars.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Description 工具箱工具选择
 * Created by Administrator on 2016/11/1 0001.
 */
public class OptionsActivity extends BaseActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5;
    private TextView titlename;
    private ImageView image;
    private TextView title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);
        initView();
    }

    @Override
    protected void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        titlename = (TextView) findViewById(R.id.title_name);
        titlename.setText("工具箱选项");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn1:
                intent.setClass(OptionsActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent.setClass(OptionsActivity.this, ZipCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn3:

                break;
            case R.id.btn4:

                break;
            case R.id.btn5:

                //toast 1 ：居中显示Toast  并将显示的时间延长
                /*Toast toast = Toast.makeText(getApplicationContext(), "作者：NiceStars --- NiceStars@qq.com",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();*/
                //Toast 2 :带图的Toast

                /*Toast toast=Toast.makeText(getApplicationContext(), "显示带图片的toast", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                //创建图片视图对象
                ImageView imageView= new ImageView(getApplicationContext());
                //设置图片
                imageView.setImageResource(R.mipmap.ic_author);
                //获得toast的布局
                LinearLayout toastView = (LinearLayout) toast.getView();
                //设置此布局为纵向的
                toastView.setOrientation(LinearLayout.VERTICAL);
                //将ImageView在加入到此布局中的第一个位置
                toastView.addView(imageView, 0);
                toast.show();*/

                showToast();



                break;

            default:

                break;


        }
    }
   //完全自定义toast
    private void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast, null);
        image = (ImageView) view.findViewById(R.id.image);
        title = (TextView) view.findViewById(R.id.title);
        content = (TextView) view.findViewById(R.id.content);
        image.setBackgroundResource(R.mipmap.ic_author);
        title.setText("作者：NiceStars");
        content.setText("NiceStars@qq.com");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();
    }
}
