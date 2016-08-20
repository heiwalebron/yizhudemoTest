package com.example.administrator.yizhudemo.tools;

import android.app.Activity;
import android.content.Intent;

import com.example.administrator.yizhudemo.R;

/**
 * Created by Administrator on 2016/8/16/016.
 */
public class Utils {
    /**
     * 关闭 Activity
     *
     * @param activity
     */
    public static void finish(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in,
                R.anim.push_right_out);
    }
    /**
     * 打开Activity
     *
     * @param activity
     * @param cls
     */
    public static void start_Activity(Activity activity, Class<?> cls
                                      ) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);

    }

}
