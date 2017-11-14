package com.example.lwp.mvp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lwp.mvp.AppApplication;
import com.example.lwp.mvp.R;
import com.example.lwp.mvp.model.Student;
import com.example.lwp.mvp.model.User;
import com.example.lwp.mvp.ui.activity.component.DaggerMainFragmentComponent;
import com.example.lwp.mvp.ui.activity.module.MainFragmentModule;
import com.example.lwp.mvp.ui.activity.presenter.MainFragmentPresenter;
import com.example.lwp.mvp.ui.activity.presenter.ViewInterface;

import javax.inject.Inject;

import hugo.weaving.DebugLog;

/**
 * com.example.lwp.mvp.fragment
 * Created by Aric on 下午3:06.
 */

public class Fragment1 extends BaseFragment implements ViewInterface {



    private TextView tvOutdata;
    private TextView tvUser;
    private TextView tvStudent;

    private String mOutData;

    @Inject
    MainFragmentPresenter mainFragmentPresenter;

    public static BaseFragment newInstance(String outData) {
        Bundle args = new Bundle();
        args.putString(OUTDATA,outData);
        BaseFragment fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    @DebugLog
    public void showInfo(User user, Student student) {
        tvStudent.setText("Student info:" +student.toString());
        tvUser.setText("User info:"+user.toString());
    }

    @Override
    @DebugLog
    public Student loadStudent() {
        return new Student("studentName","studentID");
    }

    @Override
    @DebugLog
    public User loadUser() {
        return new User("UserId","UserName");
    }

    public void getFragmentComponent(){
        DaggerMainFragmentComponent.builder()
                .appComponent(AppApplication.get(getActivity()).getAppComponent())
                .mainFragmentModule(new MainFragmentModule(Fragment1.this))
                .build()
                .inject(this);
    }

    @Override
    protected View createFragmentLayoutView(LayoutInflater inflater) {
        mOutData = getArguments().getString(OUTDATA);
        View inflate = inflater.inflate(R.layout.fragment_main, null);
        tvOutdata = (TextView) inflate.findViewById(R.id.tv_outdata);
        tvOutdata.setText(mOutData);
        tvUser = (TextView) inflate.findViewById(R.id.tv_user);
        tvStudent = (TextView) inflate.findViewById(R.id.tv_student);
        mainFragmentPresenter.loadData();
        mainFragmentPresenter.showUserName();
        return inflate;
    }
}
