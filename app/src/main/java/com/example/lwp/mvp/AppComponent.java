package com.example.lwp.mvp;

import android.app.Application;

import com.example.lwp.mvp.data.AppServiceModule;
import com.example.lwp.mvp.data.api.ApiService;
import com.example.lwp.mvp.data.api.ApiServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by aric on 2015/6/9.
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class, AppServiceModule.class})
public interface AppComponent {


    Application getApplication();

    ApiService getService();

}
