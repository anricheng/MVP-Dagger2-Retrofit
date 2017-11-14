package com.example.lwp.mvp.ui.activity.component;

import com.example.lwp.mvp.AppComponent;
import com.example.lwp.mvp.fragment.Fragment1;
import com.example.lwp.mvp.ui.activity.ActivityScope;
import com.example.lwp.mvp.ui.activity.MainActivity;
import com.example.lwp.mvp.ui.activity.module.MainActivityModule;
import com.example.lwp.mvp.ui.activity.module.MainFragmentModule;
import com.example.lwp.mvp.ui.activity.presenter.MainActivityPresenter;

import dagger.Component;

/**
 * Created by aric on 2015/6/10.
 */
@ActivityScope
@Component(modules ={ MainActivityModule.class,MainFragmentModule.class},dependencies = AppComponent.class)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);

    MainActivityPresenter getpresenter();

    Fragment1 inject(Fragment1 fragment1);


}
