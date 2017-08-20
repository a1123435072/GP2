package cn.zzu.googleplay.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangg on 2017/7/8.
 * <p>
 * 描述:易错点:需要在清单文件里面进行配置****************需要在清单文件中配置
 * static内存共享的东西
 *
 * 内存  缓存最好不要用,因为都忘里面扔,,会很大
 */

public class MyApplacation extends Application {

    private static int mainThreadId;
    private static Handler mainThreadHandler;
    private static Context context;//static变量,是不会被阿继回收器所管理的

    public static Context getmContext() {
        return context;
    }


    private Map<String,String> mMemProtoicolCacheMap = new HashMap<>();
    /**
     * 得到主线城里面查un就爱你的线程id
     *
     * @return
     */
    public static int getMainThreadId() {
        return mainThreadId;
    }

    /**
     * 得到主线程的Handler
     *
     * @return
     */
    public static Handler getMainThreadHandler() {
        return mainThreadHandler;
    }

    public static Context getContext() {
        return context;
    }

    public static int getmMainThread() {
        return mainThreadId;
    }

    /**
     * 程序一旦启动的时候,就运行
     * 创建一些常用的方法
     * 进行程序的初始化
     * 图片的三级缓存.程序的初始化
     * 耗时的操作,最好不放
     * <p>
     * 执行几次?默认执行1次,
     * 如果你把application 配置成
     */
    @Override
    public void onCreate() {//程序的入口方法
        //上下文
        context = getApplicationContext();

        //主线的Handler,因为这里是主线程,
        mainThreadHandler = new Handler();
        //主线程id,当前线程-->主线程
        /**
         * myTid  :Thread
         * myPid  :Process  进程id
         * muUid  :
         */
        mainThreadId = Process.myTid();

        super.onCreate();
    }
}
