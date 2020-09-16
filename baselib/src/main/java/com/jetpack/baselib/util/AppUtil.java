package com.jetpack.baselib.util;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import dalvik.system.DexFile;

public class AppUtil {
    public static List<String> getClassNameFromPkg(Context context, String pkgName){
        List<String>list=new ArrayList<>();
        try {
            String path=context.getPackageCodePath();
            LogUtil.e("===sourceDir===>"+path);
            DexFile dexFile=new DexFile(path);
            //获得编译后的dex文件中所有的class
            Enumeration entries=dexFile.entries();
            //遍历
            while (entries.hasMoreElements()){
                String className = (String) entries.nextElement();
                if (className.contains(pkgName)) {
                    list.add(className);
                }
            }



        }  catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
