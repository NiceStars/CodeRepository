package utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;
import cn.finalteam.okhttpfinal.RequestParams;
import model.Datasss;
import model.JHRepo;


/**
 * Description 封装了http请求类
 * Created by nicestars on 2016/10/28 0028.
 */
public class HttpUtil {

    private static HttpRequest client = new HttpRequest();
    public static void post(final String url,RequestParams params,final HttpOperation operation) {

        params.addFormDataPart("appkey", Global.appkey);//Appkey
        client.post(url, params, new BaseHttpRequestCallback<JHRepo>() {
            //这里只是网络请求成功了（也就是服务器返回JSON合法）
            // 没有没有分装具体的业务成功与失败，大家可以参考demo去分装自己公司业务请求成功与失败
            @Override
            protected void onSuccess(JHRepo apiResponse) {
                operation.onSuccesOperation(url, apiResponse);
            }

            //请求失败（服务返回非法JSON、服务器异常、网络异常）
            @Override
            public void onFailure(int errorCode, String msg) {
                operation.onFailureOperation(url, msg, errorCode);

            }

        });

    }
    }
