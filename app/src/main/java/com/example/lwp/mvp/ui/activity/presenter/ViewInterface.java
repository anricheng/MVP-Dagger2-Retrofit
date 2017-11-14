package com.example.lwp.mvp.ui.activity.presenter;

import com.example.lwp.mvp.model.Student;
import com.example.lwp.mvp.model.User;

/**
 * com.example.lwp.mvp.ui.activity.presenter
 * Created by Aric on 下午2:23.
 */

public interface ViewInterface {

    void showInfo(User user, Student student);

    Student loadStudent();

    User loadUser();
}
