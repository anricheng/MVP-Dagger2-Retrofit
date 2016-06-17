package com.example.lwp.mvp.ui.activity.presenter;

import com.example.lwp.mvp.model.Student;
import com.example.lwp.mvp.model.User;
import com.example.lwp.mvp.ui.activity.MainActivity;

/**
 * Created by clevo on 2015/6/10.
 */
public class MainActivityPresenter {

    private MainActivity mainActivity;
    private User user;
    private Student student;

    public MainActivityPresenter(MainActivity mainActivity, User user,Student student) {
        this.mainActivity = mainActivity;
        this.user = user;
        this.student=student;
    }


    public void showUserName(){
        mainActivity.setTextView(user.getName());
    }

    public void showStudentName(){
        mainActivity.setTextViews(student.getStudentName());
    }


}
