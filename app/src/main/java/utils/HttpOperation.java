package utils;



import model.JHRepo;

/**
 * Created by Administrator on 2016/3/2.
 */
public interface HttpOperation {

    void onSuccesOperation(String url, JHRepo apiResponse);

    void onFailureOperation(String url, String msg, int code);



}
