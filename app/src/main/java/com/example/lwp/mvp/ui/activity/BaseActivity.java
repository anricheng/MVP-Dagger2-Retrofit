package com.example.lwp.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lwp.mvp.AppApplication;
import com.example.lwp.mvp.AppComponent;

/**
 * Created by aric on 2015/6/10.
 */
public abstract  class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(AppApplication.get(this).getAppComponent());
    }

    protected abstract  void setupActivityComponent(AppComponent appComponent);
}
