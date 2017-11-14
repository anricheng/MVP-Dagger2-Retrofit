package com.example.lwp.mvp.ui.activity.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lwp.mvp.AppApplication;
import com.squareup.leakcanary.RefWatcher;

/**
 * com.example.lwp.mvp.ui.activity.ui.fragment
 * Created by Aric on 上午11:26.
 */

public class BaseFragment extends Fragment {

    public static final String PASSPARAMS = "passParams";

    public static BaseFragment newInstance(String passParams) {

        Bundle args = new Bundle();

        args.putString(PASSPARAMS,passParams);

        BaseFragment fragment = new BaseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override public void onDestroy() {
            super.onDestroy();
            RefWatcher refWatcher = AppApplication.getRefWatcher(getActivity());
            refWatcher.watch(this);
        }

}
