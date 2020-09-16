package com.jetpack.baselib.util.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.jetpack.baselib.util.AppUtil;
import com.jetpack.baselib.util.LogUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppRouter {
    private  Map<String,Class<? extends Activity>>ActivityMap;
    private static AppRouter router;
    private AppRouter(){
        ActivityMap=new HashMap<>();
    }
    public static AppRouter getInstance(){
        if(router==null){
            synchronized (AppRouter.class){
                if(router==null){
                    router=new AppRouter();
                }
            }
        }
        return router;
    }
    public void putAllActivity(Map<String,Class<? extends Activity>>ActivityMap ){
        this.ActivityMap.putAll(ActivityMap);

    }
    public void putActivity(String path,Class<? extends Activity>actClass ){
        this.ActivityMap.put(path,actClass);

    }

    public void start(Context context,String key){
        Intent intent=new Intent(context,ActivityMap.get(key));
        context.startActivity(intent);
    }
    public void init(Context context){
        List<String>list= AppUtil.getClassNameFromPkg(context,"com.dawn.apt");
        for (String s : list) {
            try {
                Class c=Class.forName(s);
                Method method=c.getDeclaredMethod("putAllActivity");
                method.invoke(c);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        LogUtil.e("==init==map====>"+ActivityMap);
    }



}
