package mvc.com.my_mvc.Utils;
/**
 * @date on 17:28 2018/8/12
 * @author yuyong
 * @Email yu1183688986@163.com
 * @describe 自定义的Application类，方便获取布局
 */
import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context mcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = getApplicationContext();
    }

    public static Context getContext(){
        return mcontext;
    }
}
