package cn.zzu.googleplay.util;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by yangg on 2017/7/8.
 */

public class UIUtils {
    private static String packageName;

    /**
     * 得到上下文
     */
    public static Context getContext(){
        return getContext();
    }

    /**
     * 得到资源李静
     * @return
     */
    public static Resources  getResources(){
        return getContext().getResources();
    }

    public static  String getString(int resId){
        return getResources().getString(resId);
    }
    public static String[] getStrings(int resId){
        return getResources().getStringArray(resId);
    }

    public static int getColor(int resId){
        return getResources().getColor(resId);
    }

    public static String getPackageName() {
        return getContext().getPackageName();
    }
}
