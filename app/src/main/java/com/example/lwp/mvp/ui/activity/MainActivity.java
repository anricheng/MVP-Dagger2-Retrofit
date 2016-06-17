package com.example.lwp.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lwp.mvp.AppComponent;
import com.example.lwp.mvp.R;
import com.example.lwp.mvp.ui.activity.component.DaggerMainActivityComponent;
import com.example.lwp.mvp.ui.activity.module.MainActivityModule;
import com.example.lwp.mvp.ui.activity.presenter.MainActivityPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @InjectView(R.id.tv)
    TextView textView;

    @InjectView(R.id.tv_student)
    TextView textViews;


    @Inject
    MainActivityPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
// toolbar.setLogo(R.drawable.ic_launcher);
        mToolbar.setTitle("Rocko");// 标题的文字需在setSupportActionBar之前，不然会无效
// toolbar.setSubtitle("副标题");
        setSupportActionBar(mToolbar);
/* 这些通过ActionBar来设置也是一样的，注意要在setSupportActionBar(toolbar);之后，不然就报错了 */
// getSupportActionBar().setTitle("标题");
// getSupportActionBar().setSubtitle("副标题");
// getSupportActionBar().setLogo(R.drawable.ic_launcher);

/* 菜单的监听可以在toolbar里设置，也可以像ActionBar那样，通过Activity的onOptionsItemSelected回调方法来处理 */
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, "action_settings", 0).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this, "action_share", 0).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ButterKnife.inject(this);
        presenter.showUserName();
        Log.d(TAG, "onCreate: this is the"+"times");

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);

    }

    public void setTextView(String username){
        textView.setText(username);
    }

    public void setTextViews(String username){
        textViews.setText(username);
    }




}
