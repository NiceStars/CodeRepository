package demo.cehua.nicestars.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Time:2018/7/20
 * @Author:NiceStars
 * Description:
 */
public class StudyActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_study);
        this.getMainLooper();
        Toast.makeText(this, "this.dev branch", Toast.LENGTH_SHORT).show();

        //提交一次东西


        //提交两次


    }
}
