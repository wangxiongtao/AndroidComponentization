package com.jetpack.componentization;

import com.jetpack.baselib.base.BaseApplication;

public class MyApp extends BaseApplication {
    @Override
    public void onCreate() {

//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()  //线程策略
//                .detectDiskReads()  //detect [dɪˈtɛkt] vt.查明，发现; 洞察; 侦察，侦查;
//                .detectDiskWrites()
//                .detectNetwork()
//                // or .detectAll() for all detectable problems
//                .penaltyDialog()  //penalty [ˈpɛnəlti] n.刑罚; 惩罚; 害处
//                .penaltyLog()
//                .penaltyDropBox()  //DropBox下拉框
//                .build());
//
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()  //虚拟机策略
//                .detectLeakedSqlLiteObjects()
//                .detectLeakedClosableObjects()
//                .penaltyLog()
//                .penaltyDeath()
//                .build());

        super.onCreate();
//        BlockCanary.install(this, new AppBlockCanaryContext()).start();
    }
}
