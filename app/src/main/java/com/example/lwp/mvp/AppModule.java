package com.example.lwp.mvp;

import android.app.Application;

import com.example.lwp.mvp.model.Student;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by clevo on 2015/6/9.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application=application;
    }



    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }
}
