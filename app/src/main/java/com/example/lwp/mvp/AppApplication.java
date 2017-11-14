package com.example.lwp.mvp;

import android.app.Application;
import android.content.Context;

import com.example.lwp.mvp.data.AppServiceModule;
import com.example.lwp.mvp.data.api.ApiServiceModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by aric on 2015/6/9.
 */
public class AppApplication extends Application {

    private AppComponent appComponent;
    private RefWatcher mRefWatcher;


    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        mRefWatcher = LeakCanary.install(this);
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .appServiceModule(new AppServiceModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


    public static RefWatcher getRefWatcher(Context context) {
        AppApplication application = (AppApplication) context.getApplicationContext();
        return application.mRefWatcher;
    }
}
