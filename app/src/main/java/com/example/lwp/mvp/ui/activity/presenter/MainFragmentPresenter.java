package com.example.lwp.mvp.ui.activity.presenter;

import com.example.lwp.mvp.model.Student;
import com.example.lwp.mvp.model.User;

import javax.inject.Inject;

/**
 * Created by aric on 2015/6/10.
 */
public class MainFragmentPresenter {

    private ViewInterface mViewInterface;
    private User user;
    private Student student;
    @Inject
    public MainFragmentPresenter(ViewInterface viewInterface) {
        this.mViewInterface = viewInterface;
    }

    public void loadData(){
        this.user=mViewInterface.loadUser();
        this.student=mViewInterface.loadStudent();
    }


    public void showUserName(){
        mViewInterface.showInfo(this.user,this.student);
    }

}
