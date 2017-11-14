package com.example.lwp.mvp.ui.activity.module;

import com.example.lwp.mvp.ui.activity.ActivityScope;
import com.example.lwp.mvp.ui.activity.MainActivity;
import com.example.lwp.mvp.ui.activity.presenter.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aric on 2015/6/10.
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivityPresenter provideMainActivityPresenter(MainActivity mainActivity) {
        return new MainActivityPresenter(mainActivity);
    }




}
