package demo.cehua.nicestars.activity;

import android.app.Activity;

import cn.finalteam.okhttpfinal.RequestParams;
import model.JHRepo;
import utils.HttpOperation;
import utils.HttpUtil;

/**
 * Created by Administrator on 2016/10/28 0028.
 */
public abstract class BaseActivity extends Activity implements HttpOperation {


    @Override
    public void onSuccesOperation(String url, JHRepo apiResponse) {

    }

    @Override
    public void onFailureOperation(String url, String msg, int code) {

    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

}
