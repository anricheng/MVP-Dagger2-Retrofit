package com.example.lwp.mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.lwp.mvp.AppComponent;
import com.example.lwp.mvp.R;
import com.example.lwp.mvp.fragment.Fragment1;
import com.example.lwp.mvp.model.Student;
import com.example.lwp.mvp.model.User;
import com.example.lwp.mvp.ui.activity.presenter.ViewInterface;

import butterknife.ButterKnife;


public class MainActivity extends BaseActivity  implements ViewInterface{

    private Toolbar mToolbar;

    private   FrameLayout mFragmentContainer;
    private static final String TAG = "MainActivity";
//    @InjectView(R.id.tv)
//    TextView textView;
//    @InjectView(R.id.tv_student)
//    TextView textViews;
//    @Inject
//    MainActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Aric-Test");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, Fragment1.newInstance("来自Activity的数据")).commit();
        ButterKnife.inject(this);
//method 2
//        presenter.loadData();
//
//        presenter.showUserName();
        Log.d(TAG, "onCreate: this is the"+"times");

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
//method 2
//        DaggerMainActivityComponent.builder()
//                .appComponent(appComponent)
//                .mainActivityModule(new MainActivityModule(this))
//                .build()
//                .inject(this);

    }

    @Override
    public void showInfo(User user, Student student) {
//method 2
//        textView.setText("User info:"+user.toString());
//        textViews.setText("Student info:"+ student.toString());
    }

    @Override
    public Student loadStudent() {
        return new Student("studentname","studentid");
    }

    @Override
    public User loadUser() {
        return new User("userId","Username");
    }
}
